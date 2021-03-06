##定义初始变量
#set($tableName = $tool.append($tableInfo.name, "Dao"))
##设置回调
$!callback.setFileName($tool.append($tableName, ".java"))
$!callback.setSavePath($tool.append($tableInfo.savePath, "/dao"))

##拿到主键
#if(!$tableInfo.pkColumn.isEmpty())
    #set($pk = $tableInfo.pkColumn.get(0))
#end

#if($tableInfo.savePackageName)package $!{tableInfo.savePackageName}.#{end}dao;

import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.xmty.system.entity.$!{tableInfo.name};
/**
 *  @Description    $!{tableInfo.comment}($!{tableInfo.name})表数据库访问层
 *  @author CFX
 *  @date   $!time.currTime()
 */
public interface $!{tableName} {

    /**
     * 通过ID查询单条数据
     * @param $!{pk.name}
     * @return 实例对象
     */
    $!{tableInfo.name} queryById(@Param("$!{pk.name}") $!{pk.type} $!{pk.name});

    /**
     * 查询指定行数据
     *
     * @param $!tool.firstLowerCase($!{tableInfo.name}) 实例对象
     * @return 对象列表
     */
    List<$!{tableInfo.name}> queryByParameter($!{tableInfo.name} $!tool.firstLowerCase($!{tableInfo.name}));
    
    /**
     * 查询指定行数据
     * @return 对象列表
     */
    List<$!{tableInfo.name}> queryAllList();

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<$!{tableInfo.name}> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 新增数据
     *
     * @param $!tool.firstLowerCase($!{tableInfo.name}) 实例对象
     * @return 影响行数
     */
    int insert($!{tableInfo.name} $!tool.firstLowerCase($!{tableInfo.name}));
    
    /**
     * 新增数据
     *
     * @param $!tool.firstLowerCase($!{tableInfo.name}) 实例对象
     * @return 影响行数
     */
    int insertForParameter($!{tableInfo.name} $!tool.firstLowerCase($!{tableInfo.name}));

    /**
     * 修改数据
     *
     * @param $!tool.firstLowerCase($!{tableInfo.name}) 实例对象
     * @return 影响行数
     */
    int update($!{tableInfo.name} $!tool.firstLowerCase($!{tableInfo.name}));

    /**
     * 通过主键删除数据
     * @Param  $!{pk.name}
     * @return 影响行数
     */
    int deleteById(@Param("$!{pk.name}") $!{pk.type} $!{pk.name});

    /**
     * 通过实例对象删除数据(不推荐)
     * @Param  $!tool.firstLowerCase($!{tableInfo.name}) 实例对象
     * @return 影响行数
     */
    int deleteForParameter($!{tableInfo.name} $!tool.firstLowerCase($!{tableInfo.name}));
}