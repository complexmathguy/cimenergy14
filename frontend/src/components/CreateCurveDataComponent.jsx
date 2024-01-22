import React, { Component } from 'react'
import CurveDataService from '../services/CurveDataService';

class CreateCurveDataComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
        }
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            CurveDataService.getCurveDataById(this.state.id).then( (res) =>{
                let curveData = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateCurveData = (e) => {
        e.preventDefault();
        let curveData = {
                curveDataId: this.state.id,
            };
        console.log('curveData => ' + JSON.stringify(curveData));

        // step 5
        if(this.state.id === '_add'){
            curveData.curveDataId=''
            CurveDataService.createCurveData(curveData).then(res =>{
                this.props.history.push('/curveDatas');
            });
        }else{
            CurveDataService.updateCurveData(curveData).then( res => {
                this.props.history.push('/curveDatas');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/curveDatas');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add CurveData</h3>
        }else{
            return <h3 className="text-center">Update CurveData</h3>
        }
    }
    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                {
                                    this.getTitle()
                                }
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateCurveData}>Save</button>
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

export default CreateCurveDataComponent
