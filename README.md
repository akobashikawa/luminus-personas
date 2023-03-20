# luminus-personas

- Estudiando Clojure con Luminus

## Hola MVC

- Usa el sistema de templates
- [src\clj\luminus_personas\routes\home.clj](https://github.com/akobashikawa/luminus-personas/blob/hola-mvc/src/clj/luminus_personas/routes/home.clj)

```clj
(defn home-routes []
  [ "" 
   {:middleware [
                ;;  middleware/wrap-csrf
                 middleware/wrap-formats
                 ]}
   ["/" {:get home-page}]
   ["/about" {:get about-page}]
   ["/holamundo" {:get holamundo-page}]
   ["/hola" {:get hola-page :post hola-action}]])
```

- [resources\html\holamundo.html](https://github.com/akobashikawa/luminus-personas/blob/hola-mvc/resources/html/hola.html)

```html
{% extends "base.html" %}
{% block content %}
<h1 class="title">Hola</h1>

<div class="block">
    <form action="/hola" method="POST">
        <div class="field">
            <label class="label">Nombre</label>
            <div class="control">
                <input class="input" type="text" placeholder="Nombre" name="nombre">
            </div>
        </div>
        <div class="control">
            <button class="button is-link">Hola</button>
        </div>
    </form>

</div>

<h2 class="subtitle">Hola {{ nombre }}!</h2>
{% endblock %}
```