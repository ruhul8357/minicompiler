package minicompiler.ast;

public class Assignment implements Statement {
    public final String varName;
    public final Expr expr;

    public Assignment(String varName, Expr expr) {
        this.varName = varName;
        this.expr = expr;
    }
    
    public void accept(AstVisitor v) {
        v.visit(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Assignment) {
            Assignment that = (Assignment)obj;
            return
                    this.varName.equals(that.varName) &&
                    this.expr.equals(that.expr);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return varName.hashCode() << 16 ^ expr.hashCode();
    }

    @Override
    public String toString() {
        return varName + " := " + expr;
    }
}
