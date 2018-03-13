
# Lancement: HOW TO

```bash
pushd serviceweb
./mvnw clean package docker:build
popd
docker-compose up -d
```

aller à <http://localhost:8080/etc>
ou <http://localhost:8080/var>
ou <http://localhost:8080/people>

Il y a un "Browser" si tu veux inserer des trucs en rest ici: <http://localhost:8080> (regarde le bouton jaune dans la colone "non get" pour faire un post)

## troubleshooting
Si spring ne met pas assez longtemps à charger et arrive à la partie BDD avant que posgres soit up, relance 
```bash
docker-compose up -d
```