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
import com.xmty.system.entity.$!{tableInfo.name};
 /**
 *  @Description    $!{tableInfo.comment}($!{tableInfo.name})表服务接口
 *  @author CFX
 *  @date   $!time.currTime()
 */
public interface $!{tableName} {

    /**
     * 通过ID查询单条数据
     *
     * @param 
     * @return 实例对象
     */
    $!{tableInfo.name} queryById($!{pk.type} $!{pk.name});
    
    /**
     * 通过实体作为筛选条件查询
     *
     * @param $!tool.firstLowerCase($!{tableInfo.name}) 实例对象
     * @return 对象列表
     */
    List<$!{tableInfo.name}> queryByParameter($!{tableInfo.name} $!tool.firstLowerCase($!{tableInfo.name}));
    
    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<$!{tableInfo.name}> queryAllByLimit(int offset, int limit);
    
    /**
     * 新增数据
     *
     * @param $!tool.firstLowerCase($!{tableInfo.name}) 实例对象
     * @return 实例对象
     */
    $!{tableInfo.name} insert($!{tableInfo.name} $!tool.firstLowerCase($!{tableInfo.name}));
    
    /**
     * 根据参数新增数据
     *
     * @param $!tool.firstLowerCase($!{tableInfo.name}) 实例对象
     * @return 实例对象
     */
    $!{tableInfo.name} insertForParameter($!{tableInfo.name} $!tool.firstLowerCase($!{tableInfo.name}));

    /**
     * 修改数据
     *
     * @param $!tool.firstLowerCase($!{tableInfo.name}) 实例对象
     * @return 实例对象
     */
    $!{tableInfo.name} update($!{tableInfo.name} $!tool.firstLowerCase($!{tableInfo.name}));

    /**
     * 通过主键删除数据
     * @param   $!{pk.name}
     * @return  是否成功
     */
    boolean deleteById($!{pk.type} $!{pk.name});
    
    /**
     * 通过实例对象删除数据(不推荐)
     * @param   $!tool.firstLowerCase($!{tableInfo.name}) 实例对象
     * @return  是否成功
     */
    boolean deleteForParameter($!{tableInfo.name} $!tool.firstLowerCase($!{tableInfo.name}));
}