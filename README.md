## Welche HTTP-Endpunkte erzeugt `@RepositoryRestResource(path = "tickets")` automatisch?

| HTTP-Methode | Endpunkt | Beschreibung |
|---|---|---|
| GET | `/tickets` | Alle Tickets auflisten (paginiert) |
| GET | `/tickets/{id}` | Ein einzelnes Ticket abrufen |
| POST | `/tickets` | Neues Ticket erstellen |
| PUT | `/tickets/{id}` | Ticket vollständig ersetzen |
| PATCH | `/tickets/{id}` | Ticket teilweise aktualisieren |
| DELETE | `/tickets/{id}` | Ticket löschen |

Zusätzlich werden Such-Endpunkte unter `/tickets/search/` bereitgestellt, falls im Repository eigene Query-Methoden definiert sind.

Alle Antworten sind im HAL-Format (Hypermedia Application Language) mit `_links` und `_embedded`.

## Unterschied zwischen `@RepositoryRestResource`, `@RepositoryRestController` und `@BasePathAwareController`

| Annotation | Zweck |
|---|---|
| `@RepositoryRestResource` | Wird auf ein `JpaRepository`-Interface gesetzt. Spring Data REST generiert daraus automatisch alle CRUD-Endpunkte — ohne eigenen Controller. Über `path` und `collectionResourceRel` lässt sich der URL-Pfad und der HAL-Relationsname anpassen. |
| `@RepositoryRestController` | Wird auf einen eigenen Controller gesetzt, der die automatisch generierten Endpunkte überschreiben oder erweitern soll. Er lebt im selben Pfad-Namensraum wie die generierten Endpunkte und respektiert den konfigurierten `base-path`. |
| `@BasePathAwareController` | Wird auf einen komplett eigenen Controller gesetzt, der zwar den `base-path` von Spring Data REST respektiert, aber nichts mit den Repository-Endpunkten zu tun hat. Nützlich für zusätzliche, eigenständige Endpunkte unter demselben Basispfad. |

**Kurz gesagt:**
- `@RepositoryRestResource` = automatische Endpunkte aus dem Repository
- `@RepositoryRestController` = manueller Controller, der die automatischen Endpunkte ergänzt/überschreibt
- `@BasePathAwareController` = manueller Controller unter dem gleichen Basispfad, aber unabhängig vom Repository
