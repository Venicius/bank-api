#!/bin/bash

# Espera até que o LocalStack esteja ativo
echo "Aguardando o LocalStack iniciar..."
until curl -s http://localstack:4566 > /dev/null; do
  sleep 2
done

echo "LocalStack ativo. Criando a tabela DynamoDB..."

# Definindo variáveis de ambiente para AWS CLI
export AWS_ACCESS_KEY_ID=localstack
export AWS_SECRET_ACCESS_KEY=localstack

aws dynamodb create-table \
  --table-name MyTable \
  --attribute-definitions AttributeName=id,AttributeType=S \
  --key-schema AttributeName=id,KeyType=HASH \
  --provisioned-throughput ReadCapacityUnits=5,WriteCapacityUnits=5 \
  --endpoint-url=http://localstack:4566 \
  --region us-east-1

echo "Tabela criada com sucesso! Inserindo registros..."

# Inserindo registros na tabela
aws dynamodb put-item \
    --table-name MyTable \
    --item '{"id": {"S": "1"}, "name": {"S": "Banco A"}, "location": {"S": "São Paulo"}}' \
    --endpoint-url http://localstack:4566 \
    --region us-east-1

aws dynamodb put-item \
    --table-name MyTable \
    --item '{"id": {"S": "2"}, "name": {"S": "Banco B"}, "location": {"S": "Rio de Janeiro"}}' \
    --endpoint-url http://localstack:4566 \
    --region us-east-1

aws dynamodb put-item \
    --table-name MyTable \
    --item '{"id": {"S": "3"}, "name": {"S": "Banco C"}, "location": {"S": "Belo Horizonte"}}' \
    --endpoint-url http://localstack:4566 \
    --region us-east-1

echo "Registros inseridos com sucesso!"
