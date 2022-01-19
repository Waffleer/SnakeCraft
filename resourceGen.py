import os




name = "wilted_plank"
block = True
recipe = True





defaultPath = "src\main\\resources"
absolutepath = os.path.abspath(__file__)
absolutepath = str(absolutepath)
absolutepath = absolutepath.rstrip("resourceGen.py")
absolutepath = absolutepath.rstrip("\\")

if block == True:
    try:
        f = open(f"{absolutepath}\{defaultPath}\\assets\snakecraft\\blockstates\{name}.json", "x")
        f = open(f"{absolutepath}\{defaultPath}\\assets\snakecraft\\blockstates\{name}.json", "w")
        f.write(f"""{{
        "variants": {{
            "": {{ "model":  "snakecraft:block/{name}"}}
        }}
        }}""")
        f.close()
    except FileExistsError:
        print("Block State Already Exists")

    try:
        f = open(f"{absolutepath}\{defaultPath}\\assets\snakecraft\models\\block\{name}.json", "x")
        f = open(f"{absolutepath}\{defaultPath}\\assets\snakecraft\models\\block\{name}.json", "w")
        f.write(f"""
            {{
        "parent": "block/cube_all",
        "textures": {{
            "all": "snakecraft:block/{name}"
        }}
        }}
        """)
        f.close()
    except FileExistsError:
        print("Model State Already Exists")

    try:
        f = open(f"{absolutepath}\{defaultPath}\\assets\snakecraft\models\item\{name}.json", "x")
        f = open(f"{defaultPath}\\assets\snakecraft\models\item\{name}.json", "w")
        f.write(f"""{{
        "parent": "snakecraft:block/{name}"
        }}""")
        f.close()
    except FileExistsError:
        print("Item JSON Already Exists")


    try:
        f = open(f"{absolutepath}\{defaultPath}\data\snakecraft\loot_tables\\blocks\{name}.json", "x")
        f = open(f"{absolutepath}\{defaultPath}\data\snakecraft\loot_tables\\blocks\{name}.json", "w")
        f.write(f"""{{
        "type": "minecraft:block",
        "pools": [
            {{
            "rolls": 1.0,
            "bonus_rolls": 0.0,
            "entries": [
                {{
                "type": "minecraft:item",
                "name": "snakecraft:{name}"
                }}
            ],
            "conditions": [
                {{
                "condition": "minecraft:survives_explosion"
                    }}
                ]
                }}
            ]
            }}""")
        f.close()
    except FileExistsError:
        print("Loot table Already Exists")

    if recipe:
        try:
            f = open(f"{absolutepath}\{defaultPath}\data\snakecraft\\recipes\{name}.json", "x")
            f = open(f"{absolutepath}\{defaultPath}\data\snakecraft\\recipes\{name}.json", "w")
            f.write(f"""{{
            "type": "minecraft:crafting_shaped",
            "pattern": [
                "@$@",
                "###"
            ],
            "key" : {{
                "#": {{
                "item": "snakecraft:<item>"
                }},
                "@": {{
                "item": "snakecraft:<item>"
                }}
            }},
            "result": {{
                "item": "snakecraft:{name}",
                "count": 1
                }}
                }}""")
            f.close()
        except FileExistsError:
            print("Recipe Already Exists")
            

else:
    try:
        f = open(f"{absolutepath}\{defaultPath}\\assets\snakecraft\models\item\{name}.json", "x")
        f = open(f"{absolutepath}\{defaultPath}\\assets\snakecraft\models\item\{name}.json", "w")
    
        f.write(f"""{{
        "parent": "item/generated",
            "textures": {{
                "layer0": "snakecraft:item/{name}"
            }}
        }}""")
        f.close() 
    except FileExistsError:
        print("Model Already Exists")
    

    if recipe:
        try:
            f = open(f"{absolutepath}\{defaultPath}\data\snakecraft\\recipes\{name}.json", "x")
            f = open(f"{absolutepath}\{defaultPath}\data\snakecraft\\recipes\{name}.json", "w")
            f.write(f"""{{
                "type": "minecraft:crafting_shaped",
                "pattern": [
                    "@$@",
                    "###"
                ],
                "key" : {{
                    "#": {{
                    "item": "snakecraft:<item>"
                    }},
                    "@": {{
                    "item": "snakecraft:<item>"
                    }}
                }},
                "result": {{
                    "item": "snakecraft:{name}",
                    "count": 1
                    }}
                    }}""")
            f.close()
        except FileExistsError:
            print("Recipe Already Exists")


print("Finished")