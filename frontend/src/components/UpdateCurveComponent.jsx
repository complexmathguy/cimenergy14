import React, { Component } from 'react'
import CurveService from '../services/CurveService';

class UpdateCurveComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                curveStyle: '',
                xUnit: '',
                y1Unit: '',
                y2Unit: ''
        }
        this.updateCurve = this.updateCurve.bind(this);

        this.changeCurveStyleHandler = this.changeCurveStyleHandler.bind(this);
        this.changeXUnitHandler = this.changeXUnitHandler.bind(this);
        this.changeY1UnitHandler = this.changeY1UnitHandler.bind(this);
        this.changeY2UnitHandler = this.changeY2UnitHandler.bind(this);
    }

    componentDidMount(){
        CurveService.getCurveById(this.state.id).then( (res) =>{
            let curve = res.data;
            this.setState({
                curveStyle: curve.curveStyle,
                xUnit: curve.xUnit,
                y1Unit: curve.y1Unit,
                y2Unit: curve.y2Unit
            });
        });
    }

    updateCurve = (e) => {
        e.preventDefault();
        let curve = {
            curveId: this.state.id,
            curveStyle: this.state.curveStyle,
            xUnit: this.state.xUnit,
            y1Unit: this.state.y1Unit,
            y2Unit: this.state.y2Unit
        };
        console.log('curve => ' + JSON.stringify(curve));
        console.log('id => ' + JSON.stringify(this.state.id));
        CurveService.updateCurve(curve).then( res => {
            this.props.history.push('/curves');
        });
    }

    changeCurveStyleHandler= (event) => {
        this.setState({curveStyle: event.target.value});
    }
    changeXUnitHandler= (event) => {
        this.setState({xUnit: event.target.value});
    }
    changeY1UnitHandler= (event) => {
        this.setState({y1Unit: event.target.value});
    }
    changeY2UnitHandler= (event) => {
        this.setState({y2Unit: event.target.value});
    }

    cancel(){
        this.props.history.push('/curves');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update Curve</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> CurveStyle: </label>
                                            #formFields( $attribute, 'update')
                                            <label> XUnit: </label>
                                            #formFields( $attribute, 'update')
                                            <label> Y1Unit: </label>
                                            #formFields( $attribute, 'update')
                                            <label> Y2Unit: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateCurve}>Save</button>
                                        <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Cancel</button>
                                    </form>
                                </div>
                            </div>
                        </div>

                   </div>
            </div>
        )
    }
}

export default UpdateCurveComponent
