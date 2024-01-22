import React, { Component } from 'react'
import WindContRotorRIECService from '../services/WindContRotorRIECService';

class CreateWindContRotorRIECComponent extends Component {
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
            WindContRotorRIECService.getWindContRotorRIECById(this.state.id).then( (res) =>{
                let windContRotorRIEC = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateWindContRotorRIEC = (e) => {
        e.preventDefault();
        let windContRotorRIEC = {
                windContRotorRIECId: this.state.id,
            };
        console.log('windContRotorRIEC => ' + JSON.stringify(windContRotorRIEC));

        // step 5
        if(this.state.id === '_add'){
            windContRotorRIEC.windContRotorRIECId=''
            WindContRotorRIECService.createWindContRotorRIEC(windContRotorRIEC).then(res =>{
                this.props.history.push('/windContRotorRIECs');
            });
        }else{
            WindContRotorRIECService.updateWindContRotorRIEC(windContRotorRIEC).then( res => {
                this.props.history.push('/windContRotorRIECs');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/windContRotorRIECs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add WindContRotorRIEC</h3>
        }else{
            return <h3 className="text-center">Update WindContRotorRIEC</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateWindContRotorRIEC}>Save</button>
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

export default CreateWindContRotorRIECComponent
