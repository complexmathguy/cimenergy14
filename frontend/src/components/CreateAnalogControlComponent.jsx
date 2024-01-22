import React, { Component } from 'react'
import AnalogControlService from '../services/AnalogControlService';

class CreateAnalogControlComponent extends Component {
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
            AnalogControlService.getAnalogControlById(this.state.id).then( (res) =>{
                let analogControl = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateAnalogControl = (e) => {
        e.preventDefault();
        let analogControl = {
                analogControlId: this.state.id,
            };
        console.log('analogControl => ' + JSON.stringify(analogControl));

        // step 5
        if(this.state.id === '_add'){
            analogControl.analogControlId=''
            AnalogControlService.createAnalogControl(analogControl).then(res =>{
                this.props.history.push('/analogControls');
            });
        }else{
            AnalogControlService.updateAnalogControl(analogControl).then( res => {
                this.props.history.push('/analogControls');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/analogControls');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add AnalogControl</h3>
        }else{
            return <h3 className="text-center">Update AnalogControl</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateAnalogControl}>Save</button>
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

export default CreateAnalogControlComponent
