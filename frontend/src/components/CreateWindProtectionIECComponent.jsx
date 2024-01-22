import React, { Component } from 'react'
import WindProtectionIECService from '../services/WindProtectionIECService';

class CreateWindProtectionIECComponent extends Component {
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
            WindProtectionIECService.getWindProtectionIECById(this.state.id).then( (res) =>{
                let windProtectionIEC = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateWindProtectionIEC = (e) => {
        e.preventDefault();
        let windProtectionIEC = {
                windProtectionIECId: this.state.id,
            };
        console.log('windProtectionIEC => ' + JSON.stringify(windProtectionIEC));

        // step 5
        if(this.state.id === '_add'){
            windProtectionIEC.windProtectionIECId=''
            WindProtectionIECService.createWindProtectionIEC(windProtectionIEC).then(res =>{
                this.props.history.push('/windProtectionIECs');
            });
        }else{
            WindProtectionIECService.updateWindProtectionIEC(windProtectionIEC).then( res => {
                this.props.history.push('/windProtectionIECs');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/windProtectionIECs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add WindProtectionIEC</h3>
        }else{
            return <h3 className="text-center">Update WindProtectionIEC</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateWindProtectionIEC}>Save</button>
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

export default CreateWindProtectionIECComponent
