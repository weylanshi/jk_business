package cn.itcast.jk.action.sysadmin;

import cn.itcast.jk.action.BaseAction;
import cn.itcast.jk.domain.Dept;
import cn.itcast.jk.service.DeptService;
import cn.itcast.jk.utils.Page;
import com.opensymphony.xwork2.ModelDriven;

import java.util.List;

/**
 * 部门管理的action
 * Created by WEYLAN on 2017/7/12.
 */
public class DeptAction extends BaseAction implements ModelDriven<Dept> {
    private Dept model = new Dept();

    @Override
    public Dept getModel() {
        return model;
    }

    //分页查询
    private Page page = new Page();

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    //注入DeptService
    private DeptService deptService;

    public void setDeptService(DeptService deptService) {
        this.deptService = deptService;
    }

    /**
     * 分页查询
     * @return
     * @throws Exception
     */
    public String list() throws Exception {
        page = deptService.findPage("from Dept", this.page, Dept.class, null);
        //设置分页的url地址
        page.setUrl("deptAction_list");
        //将page对象压入栈顶
        super.push(page);
        return "list";
    }

    /**
     * 进入新增页面
     */

    public String tocreate() throws Exception {
        //调用业务方法
        List<Dept> deptList = deptService.find("from Dept where state=1 ", Dept.class, null);
        //将查询结果放入值栈中
        //单个对象用push,集合用put
//        ActionContext.getContext().put("deptList",deptList);
        super.put("deptList",deptList);
        //跳页面

        return "tocreate";
    }

    /**
     * 保存
     * <s:select name="parent.id"
     * <input type="text" name="deptName" value=""/>
     * model 对象能接受
     *  parent
     *      id
     *  deptName
     * @return
     * @throws Exception
     */
    public String insert() throws Exception {
        //1.调用业务方法,实现保存
        deptService.saveOrUpdate(model);
        return "alist";
    }

    /**
     * 查看
     *  id= 123
     *  model
     * @return
     * @throws Exception
     */
    public String toview() throws Exception {
        Dept dept = deptService.get(Dept.class, this.model.getId());
        super.push(dept);
        return "toview";
    }

    /**
     * 进入修改页面
     * @return
     * @throws Exception
     */
    public String toupdate() throws Exception {
        //根据id得到一个对象
        Dept obj = deptService.get(Dept.class, model.getId());
        //将对象放入值栈中
        super.push(obj);
        //查询父部门
        List<Dept> deptList = deptService.find("from Dept where state=1 ", Dept.class, null);
        //将查询结果放入值栈中
        super.put("deptList",deptList);
        return "toupdate";
    }

    /**
     * 修改
     * @return
     * @throws Exception
     */
    public String update() throws Exception {
        Dept obj = deptService.get(Dept.class,model.getId());//根据id,得到一个数据库中保存的对象
        //设置修改的属性
        obj.setParent(model.getParent());
        obj.setDeptName(model.getDeptName());
        deptService.saveOrUpdate(obj);
        return "alist";
    }

    /**
     *  *<input type="checkbox" name="id" value="${dept.id }"/>
     *<input type="checkbox" name="id" value="${dept.id }"/>
     * 删除
     * model
     *  id: Stirng
     *      具有同名框的一组值如何封装数据?
     *      如果服务器端是Sting类型:
     *              100,100sad,asdf  默认使用逗号分隔
     *       id:Integer,Float ,Double,Dete...等等 类型    id=19   id 200  id= 300   整数默认只保留最后一个值
     *       Integer[] id ; {100,200,300}
     */

    public String delet() throws Exception {
        String ids[] = model.getId().split(",");
        //调用业务方法,实现批量删除
        deptService.delete(Dept.class,ids);

        return "alist";
    }
}
