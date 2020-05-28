package tto

import "testing"

func TestTemplate(t *testing.T) {
	tp := NewTemplate(`/**
 * this file is auto generated by tto v{{.global.Version}} !
 * if you want to modify this code,please read guide doc
 * and modify code template later.
 *
 * guide please see https://github.com/ixre/tto
 *
 */
!filename:{{.table.Title}}Entity.java
package {{.global.Pkg}}.pojo;

 {{range $i,$c := $validateColumns}}\
  column: {{$c.Name}}
 {{end}}

`, "")

	t.Log(tp.String())
}
