##定义初始变量
#set($tableName = $tool.append($tableInfo.name, "Service"))
##设置回调
$!callback.setFileName($tool.append($tableName, ".java"))
$!callback.setSavePath($tool.append($tableInfo.savePath, "/service"))

##拿到主键
#if(!$tableInfo.pkColumn.isEmpty())
    #set($pk = $tableInfo.pkColumn.get(0))
#end

#if($tableInfo.savePackageName)package $!{tableInfo.savePackageName}.#{end}service;

import java.util.List;
import com.xmty.entity.$!{tableInfo.name};
/**
 * $!{tableInfo.comment}($!{tableInfo.name})表服务接口
 *  $!time.currTime()
 */
public interface $!{tableName} {

    /**
     * 通过ID查询单条数据
     *
     * @param 
     * @return 实例对象
     */
    $!{tableInfo.name} queryById($!{tableInfo.name} $!tool.firstLowerCase($!{tableInfo.name}));

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<$!{tableInfo.name}> queryAllByLimit(int offset, int limit);
/**
     * 通过实体作为筛选条件查询
     *
     * @param $!tool.firstLowerCase($!{tableInfo.name}) 实例对象
     * @return 对象列表
     */
    List<$!{tableInfo.name}> queryAll($!{tableInfo.name} $!tool.firstLowerCase($!{tableInfo.name}));
    $!{tableInfo.name} query($!{tableInfo.name} $!tool.firstLowerCase($!{tableInfo.name}));
    /**
     * 新增数据
     *
     * @param $!tool.firstLowerCase($!{tableInfo.name}) 实例对象
     * @return 实例对象
     */
    $!{tableInfo.name} insert($!{tableInfo.name} $!tool.firstLowerCase($!{tableInfo.name}));

    /**
     * 修改数据
     *
     * @param $!tool.firstLowerCase($!{tableInfo.name}) 实例对象
     * @return 实例对象
     */
    $!{tableInfo.name} update($!{tableInfo.name} $!tool.firstLowerCase($!{tableInfo.name}));

    /**
     * 通过主键删除数据
     *
     * @param 
     * @return 是否成功
     */
    boolean deleteById($!{tableInfo.name} $!tool.firstLowerCase($!{tableInfo.name}));
     boolean delete($!{tableInfo.name} $!tool.firstLowerCase($!{tableInfo.name}));
}