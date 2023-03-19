# luminus-personas

- Estudiando Clojure con Luminus

## Hola Mundo MVC

- Usa el sistema de templates
- [src\clj\luminus_personas\routes\home.clj](https://github.com/akobashikawa/luminus-personas/blob/holamundo-mvc/src/clj/luminus_personas/routes/home.clj)

```clj
(defn holamundo-page [request]
  (layout/render request "holamundo.html"))
;; ...
(defn home-routes []
  [ "" 
   ;; ...
   ["/" {:get home-page}]
   ["/about" {:get about-page}]
   ["/holamundo" {:get holamundo-page}]])
```

- [resources\html\holamundo.html](https://github.com/akobashikawa/luminus-personas/blob/holamundo-mvc/resources/html/holamundo.html)

```html
{% extends "base.html" %}
{% block content %}
  <h1 class="title">Hola Mundo</h1>
{% endblock %}
```