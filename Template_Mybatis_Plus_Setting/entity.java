##导入宏定义
$!define

##保存文件（宏定义）
#save("/entity", ".java")

##包路径（宏定义）
#setPackageSuffix("entity")

##自动导入包（全局变量）
$!autoImport
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.springframework.format.annotation.DateTimeFormat;


import java.io.Serializable;


##表注释（宏定义）
#tableComment("表实体类")
@Data
@TableName("$!{tableInfo.obj.name}")
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="${tableInfo.name}对象", description="${tableInfo.comment}")
public class $!{tableInfo.name} extends Model<$!{tableInfo.name}> implements Serializable {
    private static final long serialVersionUID = $!tool.serial();
#foreach($column in $tableInfo.fullColumn)
#if(${column.type} == "java.util.Date")
	@Excel(name = "${column.obj.name}", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
#end
#if(${column.type} != "java.util.Date")
	@Excel(name = "${column.obj.name}", width = 15)
#end
    @ApiModelProperty(value = "${column.comment}")
    private $!{tool.getClsNameByFullName($column.type)} $!{column.name};
#end

#foreach($column in $tableInfo.pkColumn)
    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.$!column.name;
    }
   #break
#end

}