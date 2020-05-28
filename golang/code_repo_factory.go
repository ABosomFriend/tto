package golang

var TPL_REPO_FACTORY = `
        package {{pkg "go" .global.Pkg}} 

/**
 * this file is auto generated by tto v{{.global.Version}} !
 * if you want to modify this code,please read guide doc
 * and modify code template later.
 *
 * guide please see https://github.com/ixre/tto
 * generate time: {{.global.Time}}
 */
#!target:{{.global.Pkg}}/repo_factory.go

		import(
		    "github.com/ixre/gof/db/orm"
		    "{{.global.Pkg}}/model"
		    "{{.global.Pkg}}/repo"
		    "{{.global.Pkg}}/ifce"
		)

		type repoFactory struct{
			o orm.Orm
		{{range $i,$tb := .tables}}
		    _{{$tb.Name}}_repo ifce.I{{$tb.Title}}Repo{{end}}
		}

		// 创建仓储工厂
		func NewRepoFactory(o orm.Orm)*repoFactory{
			r := &repoFactory{
				o:o,
			}
			return r.init()
		}
		func (r *repoFactory) init()*repoFactory{
        {{range $i,$tb := .tables}}
		    r.o.Mapping(model.{{$tb.Title}}{},"{{$tb.Name}}"){{end}}
		    return r
		}
		{{range $i,$tb := .Tables}}
		// 获取{{$tb.Comment}}仓储
		func (r *repoFactory) Get{{$tb.Title}}Repo()ifce.I{{$tb.Title}}Repo{
		    if r._{{$tb.Name}}_repo == nil{
		        r._{{$tb.Name}}_repo = repo.New{{$tb.Title}}Repo(r.o)
		    }
		    return r._{{$tb.Name}}_repo
		}
		{{end}}
`
