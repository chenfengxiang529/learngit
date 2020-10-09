##定义初始变量
#set($tableName = $tool.append($tableInfo.name, "Controller"))
##设置回调
$!callback.setFileName($tool.append($tableName, ".java"))
$!callback.setSavePath($tool.append($tableInfo.savePath, "/controller"))
##拿到主键
#if(!$tableInfo.pkColumn.isEmpty())
    #set($pk = $tableInfo.pkColumn.get(0))
#end

#if($tableInfo.savePackageName)package $!{tableInfo.savePackageName}.#{end}controller;

import $!{tableInfo.savePackageName}.service.$!{tableInfo.name}Service;
import org.springframework.web.bind.annotation.*;
import com.xhwl.entity.$!{tableInfo.name};
import javax.annotation.Resource;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
/**
 * $!{tableInfo.comment}($!{tableInfo.name})表控制层
 *  $!time.currTime()
 */
@RestController
@RequestMapping("/$!tool.firstLowerCase($tableInfo.name)")
public class $!{tableName} {
    /**
     * 服务对象
     */
    @Resource
    private $!{tableInfo.name}Service $!tool.firstLowerCase($tableInfo.name)Service;
    @Resource
    private IdWorker idworker;
    /**
     * 通过主键查询单条数据
     *
     * @param 
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public $!{tableInfo.name} selectOne($!{tableInfo.name} $!tool.firstLowerCase($!{tableInfo.name})) {
        return this.$!{tool.firstLowerCase($tableInfo.name)}Service.queryById($!tool.firstLowerCase($!{tableInfo.name}));
    }
    
    

}