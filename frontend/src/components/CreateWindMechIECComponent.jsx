import React, { Component } from 'react'
import WindMechIECService from '../services/WindMechIECService';

class CreateWindMechIECComponent extends Component {
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
            WindMechIECService.getWindMechIECById(this.state.id).then( (res) =>{
                let windMechIEC = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateWindMechIEC = (e) => {
        e.preventDefault();
        let windMechIEC = {
                windMechIECId: this.state.id,
            };
        console.log('windMechIEC => ' + JSON.stringify(windMechIEC));

        // step 5
        if(this.state.id === '_add'){
            windMechIEC.windMechIECId=''
            WindMechIECService.createWindMechIEC(windMechIEC).then(res =>{
                this.props.history.push('/windMechIECs');
            });
        }else{
            WindMechIECService.updateWindMechIEC(windMechIEC).then( res => {
                this.props.history.push('/windMechIECs');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/windMechIECs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add WindMechIEC</h3>
        }else{
            return <h3 className="text-center">Update WindMechIEC</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateWindMechIEC}>Save</button>
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

export default CreateWindMechIECComponent
