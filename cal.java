 ScriptEngine se = new ScriptEngineManager().getEngineByName("JavaScript");
        String str = "2*3-45/5+9+9%5";
        try {
            Object d = se.eval(str);
            System.out.println(d);
        } catch (ScriptException e) {
            e.printStackTrace();
        }