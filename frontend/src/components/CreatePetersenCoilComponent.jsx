import React, { Component } from 'react'
import PetersenCoilService from '../services/PetersenCoilService';

class CreatePetersenCoilComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                mode: ''
        }
        this.changeModeHandler = this.changeModeHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            PetersenCoilService.getPetersenCoilById(this.state.id).then( (res) =>{
                let petersenCoil = res.data;
                this.setState({
                    mode: petersenCoil.mode
                });
            });
        }        
    }
    saveOrUpdatePetersenCoil = (e) => {
        e.preventDefault();
        let petersenCoil = {
                petersenCoilId: this.state.id,
                mode: this.state.mode
            };
        console.log('petersenCoil => ' + JSON.stringify(petersenCoil));

        // step 5
        if(this.state.id === '_add'){
            petersenCoil.petersenCoilId=''
            PetersenCoilService.createPetersenCoil(petersenCoil).then(res =>{
                this.props.history.push('/petersenCoils');
            });
        }else{
            PetersenCoilService.updatePetersenCoil(petersenCoil).then( res => {
                this.props.history.push('/petersenCoils');
            });
        }
    }
    
    changeModeHandler= (event) => {
        this.setState({mode: event.target.value});
    }

    cancel(){
        this.props.history.push('/petersenCoils');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add PetersenCoil</h3>
        }else{
            return <h3 className="text-center">Update PetersenCoil</h3>
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
                                            <label> Mode: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdatePetersenCoil}>Save</button>
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

export default CreatePetersenCoilComponent
