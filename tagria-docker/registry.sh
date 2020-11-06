aws ecr get-login-password --region us-east-1 | docker login --username AWS --password-stdin 396182636964.dkr.ecr.us-east-1.amazonaws.com/jslsolucoes/tagria
docker tag jslsolucoes/tagria:4.0.37 396182636964.dkr.ecr.us-east-1.amazonaws.com/jslsolucoes/tagria:4.0.37
docker push 396182636964.dkr.ecr.us-east-1.amazonaws.com/jslsolucoes/tagria:4.0.37