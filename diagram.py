from diagrams import Cluster, Diagram
from diagrams.aws.compute import ECS
from diagrams.aws.database import ElastiCache, RDS
from diagrams.aws.network import ELB
from diagrams.aws.network import Route53

with Diagram("Unicorn Stack Architecture", show=False):
    apps = ELB("android app")

    with Cluster("UnicornStack Services"):
        svc_group = [ECS("service1"),
                     ECS("service2"),
                     ECS("service3")]

    with Cluster("Database Layer"):
        db_primary = RDS("auth")
        db_primary - [RDS("services")]

    memcached = ElastiCache("memcached")

    apps >> svc_group
    svc_group >> db_primary
    svc_group >> memcached
