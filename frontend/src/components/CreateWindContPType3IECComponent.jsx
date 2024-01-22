import React, { Component } from 'react'
import WindContPType3IECService from '../services/WindContPType3IECService';

class CreateWindContPType3IECComponent extends Component {
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
            WindContPType3IECService.getWindContPType3IECById(this.state.id).then( (res) =>{
                let windContPType3IEC = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateWindContPType3IEC = (e) => {
        e.preventDefault();
        let windContPType3IEC = {
                windContPType3IECId: this.state.id,
            };
        console.log('windContPType3IEC => ' + JSON.stringify(windContPType3IEC));

        // step 5
        if(this.state.id === '_add'){
            windContPType3IEC.windContPType3IECId=''
            WindContPType3IECService.createWindContPType3IEC(windContPType3IEC).then(res =>{
                this.props.history.push('/windContPType3IECs');
            });
        }else{
            WindContPType3IECService.updateWindContPType3IEC(windContPType3IEC).then( res => {
                this.props.history.push('/windContPType3IECs');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/windContPType3IECs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add WindContPType3IEC</h3>
        }else{
            return <h3 className="text-center">Update WindContPType3IEC</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateWindContPType3IEC}>Save</button>
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

export default CreateWindContPType3IECComponent
