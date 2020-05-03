/**
 * this file is auto generated by TTO-CodeGenerator v{{.global.Version}} !
 * if you want to modify this code,please read guide doc
 * and modify code template later.
 *
 * guide please see https://github.com/ixre/tto
 *
 */
#!target:kotlin/{{.global.Pkg}}/model/{{.table.Title}}Entity.kt
package {{pkg "kotlin" .global.Pkg}}.model;

/** {{.table.Comment}} */
class {{.table.Title}}{
    {{range $i,$c:=.columns}}
    /** {{$c.Comment}} */
    var {{lower_title $c.Title}}:{{type "kotlin" $c.Type}} = {{default "kotlin" $c.Type}} {{end}}

    /** 拷贝数据  */
    fun  copy(src :{{.table.Title}}Entity):{{.table.Title}}Entity{
        val dst = this;
        {{range $i,$c := .columns}}
        dst.{{lower_title $c.Title}} = src.{{lower_title $c.Title}}{{end}}
        return dst;
    }
}