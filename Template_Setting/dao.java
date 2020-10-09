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
import com.xhwl.entity.$!{tableInfo.name};
/**
 * $!{tableInfo.comment}($!{tableInfo.name})表数据库访问层
 *  $!time.currTime()
 */
public interface $!{tableName} {

    /**
     * 通过ID查询单条数据
     *
     * @return 实例对象
     */
    $!{tableInfo.name} queryById($!{tableInfo.name} $!tool.firstLowerCase($!{tableInfo.name}));

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<$!{tableInfo.name}> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


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
     * @return 影响行数
     */
    int insert($!{tableInfo.name} $!tool.firstLowerCase($!{tableInfo.name}));

    /**
     * 修改数据
     *
     * @param $!tool.firstLowerCase($!{tableInfo.name}) 实例对象
     * @return 影响行数
     */
    int update($!{tableInfo.name} $!tool.firstLowerCase($!{tableInfo.name}));

    /**
     * 通过主键删除数据
     *
     * @return 影响行数
     */
    int deleteById($!{tableInfo.name} $!tool.firstLowerCase($!{tableInfo.name}));
/**

     *
     * @return 影响行数
     */
    int delete($!{tableInfo.name} $!tool.firstLowerCase($!{tableInfo.name}));
}