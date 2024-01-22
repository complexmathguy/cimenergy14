import React, { Component } from 'react'
import TapChangerTablePointService from '../services/TapChangerTablePointService';

class CreateTapChangerTablePointComponent extends Component {
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
            TapChangerTablePointService.getTapChangerTablePointById(this.state.id).then( (res) =>{
                let tapChangerTablePoint = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateTapChangerTablePoint = (e) => {
        e.preventDefault();
        let tapChangerTablePoint = {
                tapChangerTablePointId: this.state.id,
            };
        console.log('tapChangerTablePoint => ' + JSON.stringify(tapChangerTablePoint));

        // step 5
        if(this.state.id === '_add'){
            tapChangerTablePoint.tapChangerTablePointId=''
            TapChangerTablePointService.createTapChangerTablePoint(tapChangerTablePoint).then(res =>{
                this.props.history.push('/tapChangerTablePoints');
            });
        }else{
            TapChangerTablePointService.updateTapChangerTablePoint(tapChangerTablePoint).then( res => {
                this.props.history.push('/tapChangerTablePoints');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/tapChangerTablePoints');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add TapChangerTablePoint</h3>
        }else{
            return <h3 className="text-center">Update TapChangerTablePoint</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateTapChangerTablePoint}>Save</button>
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

export default CreateTapChangerTablePointComponent
