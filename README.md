# clojurescript-tdd-application

Clojurescript test showcase, based on https://8thlight.com/blog/eric-smith/2016/10/05/a-testable-clojurescript-setup.html

See also https://github.com/kapware/cljs-tdd for leiningen template.

# Running phantomjs tests (headless, slower, for CI)
```
lein cljsbuild test
```

# Running tests in browser (quick, typical workflow)
```
lein figwheel devcards-test dev
```

## License

Copyright © 2017 kapware

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
