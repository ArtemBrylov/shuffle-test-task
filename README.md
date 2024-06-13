# shuffle-test-task

## Example of usage:
### service-shuffle:
```bash
curl -X POST "http://localhost:8085/shuffle?number=7"
```

### service-log:
```bash
curl -X POST "http://localhost:8086/log" \
-H "Content-Type: application/json" \
-d '{"message":"This is a test message"}'
```