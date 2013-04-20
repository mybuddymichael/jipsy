```clojure
(def root this)

(defn square [x] (* x x))
```
```javascript
var root = this;

var square = function square(x) {
  return x * x;
}
```

```clojure
(defn cube [x]
  (let [x-squared (square x)]
    (* x x-squared)))
```
```javascript
var cube = function cube(x) {
  var xSquared = square(x);
  return x * xSquared;
}
```

```clojure
[3 7 foo bar]
'(3 7 foo bar)
```
```javascript
[3, 7, foo, bar];
[3, 7, foo, bar];
```

```clojure
{:foo 2 :bar baz}
```
```javascript
{"foo": 2, "bar": baz};
```
