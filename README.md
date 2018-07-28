Java URLConnection Follows Redirect Demo
========================================

If a url responses with `redirect`, how to handle it with `URLConnection`

Run `Hello.java` in your IDE.

Notice
------

This works only when the redirection keeps the same scheme, e.g. `http` -> `http`.

It won't work if it redirects from `http` to `https`