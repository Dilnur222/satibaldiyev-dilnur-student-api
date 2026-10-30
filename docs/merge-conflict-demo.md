# Git branching and merge conflict exercise

Branches:
- `feature/satibaldiyev-dilnur-crud`
- `feature/satibaldiyev-dilnur-documentation`

The same "Documentation status" line in README.md was changed differently on the documentation branch and on main. The two histories were merged with a two-parent commit containing the manually chosen resolution:

`Documentation status: Reviewed and merged by Dilnur Satibaldiyev.`

Review the real GitHub commit graph and parent relationships to verify the divergent changes.

```bash
git log --oneline --graph --all
git branch -a
```
