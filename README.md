# to run in development mode
- set -Dspring.profiles.active=local in VM arguments
- npm run build && npm run watch(build: copies files to build/resources)
  (watch: once copied, it watches changes if changes then copies and reloads the browser)
- run the java application
