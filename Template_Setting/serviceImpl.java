##定义初始变量
#set($tableName = $tool.append($tableInfo.name, "ServiceImpl"))
##设置回调
$!callback.setFileName($tool.append($tableName, ".java"))
$!callback.setSavePath($tool.append($tableInfo.savePath, "/service/impl"))

##拿到主键
#if(!$tableInfo.pkColumn.isEmpty())
    #set($pk = $tableInfo.pkColumn.get(0))
#end

#if($tableInfo.savePackageName)package $!{tableInfo.savePackageName}.#{end}service.impl;

import $!{tableInfo.savePackageName}.dao.$!{tableInfo.name}Dao;
import $!{tableInfo.savePackageName}.service.$!{tableInfo.name}Service;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import com.xmty.system.entity.$!{tableInfo.name};
/**
 * $!{tableInfo.comment}($!{tableInfo.name})表服务实现类
 *  $!time.currTime()
 */
@Service("$!tool.firstLowerCase($!{tableInfo.name})Service")
public class $!{tableName} implements $!{tableInfo.name}Service {
    @Resource
    private $!{tableInfo.name}Dao $!tool.firstLowerCase($!{tableInfo.name})Dao;

    /**
     * 通过ID查询单条数据
     *
     * @param   $!{pk.name}
     * @return  实例对象
     */
    @Override
    public $!{tableInfo.name} queryById($!{pk.type} $!{pk.name}) {
        return $!{tool.firstLowerCase($!{tableInfo.name})}Dao.queryById($!{pk.name});
    }
    
    /**
     * 通过实体作为筛选条件查询
     *
     * @param $!tool.firstLowerCase($!{tableInfo.name}) 实例对象
     * @return 对象列表
     */
   public List<$!{tableInfo.name}> queryByParameter($!{tableInfo.name} $!tool.firstLowerCase($!{tableInfo.name})){
           return $!{tool.firstLowerCase($!{tableInfo.name})}Dao.queryByParameter($!tool.firstLowerCase($!{tableInfo.name}));
   }
    
    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<$!{tableInfo.name}> queryAllByLimit(int offset, int limit) {
        return $!{tool.firstLowerCase($!{tableInfo.name})}Dao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param   $!tool.firstLowerCase($!{tableInfo.name}) 实例对象
     * @return  是否成功
     */
    @Override
    public boolean insert($!{tableInfo.name} $!tool.firstLowerCase($!{tableInfo.name})) {
        return $!{tool.firstLowerCase($!{tableInfo.name})}Dao.insert($!tool.firstLowerCase($!{tableInfo.name}));
    }
    
    /**
     * 根据参数新增列
     *
     * @param   $!tool.firstLowerCase($!{tableInfo.name}) 实例对象
     * @return  是否成功
     */
    @Override
    public boolean insertForParameter($!{tableInfo.name} $!tool.firstLowerCase($!{tableInfo.name})) {
        return $!{tool.firstLowerCase($!{tableInfo.name})}Dao.insert($!tool.firstLowerCase($!{tableInfo.name})) > 0;
    }
    
    /**
     * 修改数据
     *
     * @param $!tool.firstLowerCase($!{tableInfo.name}) 实例对象
     * @return 实例对象
     */
    @Override
    public boolean update($!{tableInfo.name} $!tool.firstLowerCase($!{tableInfo.name})) {
        return $!{tool.firstLowerCase($!{tableInfo.name})}Dao.update($!tool.firstLowerCase($!{tableInfo.name})) > 0;
    }

    /**
     * 通过主键删除数据
     *
     * @param   $!{pk.name}
     * @return  是否成功
     */
    @Override
    public boolean deleteById($!{pk.type} $!{pk.name}) {
        return $!{tool.firstLowerCase($!{tableInfo.name})}Dao.deleteById($!{pk.name}) > 0;
    }
	
    /**
     * 通过实例对象删除数据(不推荐)
     * @param   $!tool.firstLowerCase($!{tableInfo.name}) 实例对象
     * @return  是否成功
     */
    @Override
    public boolean deleteForParameter($!{tableInfo.name} $!tool.firstLowerCase($!{tableInfo.name})) {
        return $!{tool.firstLowerCase($!{tableInfo.name})}Dao.deleteById($!tool.firstLowerCase($!{tableInfo.name})) > 0;
    }
}