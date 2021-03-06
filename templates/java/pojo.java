/**
 * this file is auto generated by TTO-CodeGenerator v{{.global.Version}} !
 * if you want to modify this code,please read guide doc
 * and modify code template later.
 *
 * guide please see https://github.com/ixre/tto
 *
 */
#!target:java/{{.global.Pkg}}/pojo/{{.table.Title}}Entity.java
package {{pkg "java" .global.Pkg}}.pojo;

import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;


/** {{.table.Comment}} */
@Entity
@Table(name = "{{.table.Name}}", schema = "{{.table.Schema}}")
@Cache(usage= CacheConcurrencyStrategy.READ_WRITE)//可读可写
public class {{.table.Title}}Entity {
    {{range $i,$c := .columns}}{{$type := type "java" $c.Type}}
    private {{$type}} {{$c.Name}};
    public void set{{$c.Prop}}({{$type}} {{$c.Name}}){
        this.{{$c.Name}} = {{$c.Name}};
    }

    /** {{$c.Comment}} */{{if $c.IsPk}}
    @Id{{if $c.IsAuto}}
    @GeneratedValue(strategy = GenerationType.IDENTITY){{else}}
    @GenericGenerator(name = "id",strategy = "assigned"){{end}}{{else}}
    @Basic{{end}}
    @Column(name = "{{$c.Name}}"{{if not $c.NotNull}}, nullable = true{{end}} {{if ne $c.Length 0}},length = {{$c.Length}}{{end}})
    public {{$type}} get{{$c.Prop}}() {
        return this.{{$c.Name}};
    }
    {{end}}

    /** 拷贝数据  */
    public {{.table.Title}}Entity copy({{.table.Title}}Entity src){
        {{.table.Title}}Entity dst = this;
        {{range $i,$c := .columns}}
        dst.set{{$c.Prop}}(src.get{{$c.Prop}}());{{end}}
        return dst;
    }
}
