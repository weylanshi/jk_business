package cn.itcast.jk.action.sysadmin;

import cn.itcast.jk.action.BaseAction;
import cn.itcast.jk.domain.Dept;
import cn.itcast.jk.service.DeptService;
import cn.itcast.jk.utils.Page;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 部门管理的action
 * Created by WEYLAN on 2017/7/12.
 */
public class DeptAction extends BaseAction implements ModelDriven<Dept> {
    private Dept dept = new Dept();

    @Override
    public Dept getModel() {
        return dept;
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
}
