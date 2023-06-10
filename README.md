# to run in development mode
- set `-Dspring.profiles.active=local` in VM arguments
- if you want to populate users data to database then run the programme with "init-db" profile with local profile in VM arguments.
- `-Dspring.profiles.active=local,init-db`
- run the java application 
- `npm run build && npm run watch` </br> (build: copies files to build/resources)
  (watch: once copied, it watches changes if changes then copies and reloads the browser)
- run npx tailwind css </br>
`npx tailwindcss -i ./src/main/resources/static/css/application.css -o ./build/resources/main/static/css/application.css --watch`
