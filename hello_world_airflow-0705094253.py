from airflow import DAG
from airflow_notebook.pipeline import NotebookOp
from airflow.utils.dates import days_ago

# Setup default args with older date to automatically trigger when uploaded
args = {
    "project_id": "hello_world_airflow-0705094253",
}

dag = DAG(
    "hello_world_airflow-0705094253",
    default_args=args,
    schedule_interval="@once",
    start_date=days_ago(1),
    description="Created with Elyra 2.2.1 pipeline editor using hello_world_airflow.pipeline.",
    is_paused_upon_creation=False,
)


notebook_op_dc69c562_0968_4daf_b252_bf988b058537 = NotebookOp(
    name="load_data",
    namespace="default",
    task_id="load_data",
    notebook="work/demo/hello_world/load_data.py",
    cos_endpoint="http://172.24.21.17:19000",
    cos_bucket="mlpipeline",
    cos_directory="hello_world_airflow-0705094253",
    cos_dependencies_archive="load_data-dc69c562-0968-4daf-b252-bf988b058537.tar.gz",
    pipeline_outputs=["data/noaa-weather-data-jfk-airport/jfk_weather.csv"],
    pipeline_inputs=[],
    image="amancevice/pandas:1.1.1",
    resources={
        "request_cpu": "1",
        "request_memory": "1",
    },
    in_cluster=True,
    env_vars={
        "AWS_ACCESS_KEY_ID": "admin",
        "AWS_SECRET_ACCESS_KEY": "admin123456",
        "ELYRA_ENABLE_PIPELINE_INFO": "True",
        "DATASET_URL": "https://dax-cdn.cdn.appdomain.cloud/dax-noaa-weather-data-jfk-airport/1.1.4/noaa-weather-data-jfk-airport.tar.gz",
    },
    config_file="None",
    dag=dag,
)


notebook_op_d2081fb7_2f36_43da_9331_594a190245b5 = NotebookOp(
    name="Part_1___Data_Cleaning",
    namespace="default",
    task_id="Part_1___Data_Cleaning",
    notebook="work/demo/hello_world/Part 1 - Data Cleaning.ipynb",
    cos_endpoint="http://172.24.21.17:19000",
    cos_bucket="mlpipeline",
    cos_directory="hello_world_airflow-0705094253",
    cos_dependencies_archive="Part 1 - Data Cleaning-d2081fb7-2f36-43da-9331-594a190245b5.tar.gz",
    pipeline_outputs=[],
    pipeline_inputs=["data/noaa-weather-data-jfk-airport/jfk_weather.csv"],
    image="amancevice/pandas:1.1.1",
    resources={
        "request_cpu": "1",
        "request_memory": "1",
    },
    in_cluster=True,
    env_vars={
        "AWS_ACCESS_KEY_ID": "admin",
        "AWS_SECRET_ACCESS_KEY": "admin123456",
        "ELYRA_ENABLE_PIPELINE_INFO": "True",
    },
    config_file="None",
    dag=dag,
)

notebook_op_d2081fb7_2f36_43da_9331_594a190245b5 << notebook_op_dc69c562_0968_4daf_b252_bf988b058537


notebook_op_973545fd_6d81_4b0f_9e7e_e0d03950b1f0 = NotebookOp(
    name="Part_2___Data_Analysis",
    namespace="default",
    task_id="Part_2___Data_Analysis",
    notebook="work/demo/hello_world/Part 2 - Data Analysis.ipynb",
    cos_endpoint="http://172.24.21.17:19000",
    cos_bucket="mlpipeline",
    cos_directory="hello_world_airflow-0705094253",
    cos_dependencies_archive="Part 2 - Data Analysis-973545fd-6d81-4b0f-9e7e-e0d03950b1f0.tar.gz",
    pipeline_outputs=[],
    pipeline_inputs=["data/noaa-weather-data-jfk-airport/jfk_weather.csv"],
    image="amancevice/pandas:1.1.1",
    resources={
        "request_cpu": "1",
        "request_memory": "1",
    },
    in_cluster=True,
    env_vars={
        "AWS_ACCESS_KEY_ID": "admin",
        "AWS_SECRET_ACCESS_KEY": "admin123456",
        "ELYRA_ENABLE_PIPELINE_INFO": "True",
    },
    config_file="None",
    dag=dag,
)

notebook_op_973545fd_6d81_4b0f_9e7e_e0d03950b1f0 << notebook_op_d2081fb7_2f36_43da_9331_594a190245b5


notebook_op_a11b5689_267d_46de_a055_64d5a4c384ee = NotebookOp(
    name="Part_3___Time_Series_Forecasting",
    namespace="default",
    task_id="Part_3___Time_Series_Forecasting",
    notebook="work/demo/hello_world/Part 3 - Time Series Forecasting.ipynb",
    cos_endpoint="http://172.24.21.17:19000",
    cos_bucket="mlpipeline",
    cos_directory="hello_world_airflow-0705094253",
    cos_dependencies_archive="Part 3 - Time Series Forecasting-a11b5689-267d-46de-a055-64d5a4c384ee.tar.gz",
    pipeline_outputs=[],
    pipeline_inputs=["data/noaa-weather-data-jfk-airport/jfk_weather.csv"],
    image="amancevice/pandas:1.1.1",
    resources={
        "request_cpu": "1",
        "request_memory": "1",
    },
    in_cluster=True,
    env_vars={
        "AWS_ACCESS_KEY_ID": "admin",
        "AWS_SECRET_ACCESS_KEY": "admin123456",
        "ELYRA_ENABLE_PIPELINE_INFO": "True",
    },
    config_file="None",
    dag=dag,
)

notebook_op_a11b5689_267d_46de_a055_64d5a4c384ee << notebook_op_d2081fb7_2f36_43da_9331_594a190245b5
