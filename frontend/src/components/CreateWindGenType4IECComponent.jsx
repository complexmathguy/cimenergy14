import React, { Component } from 'react'
import WindGenType4IECService from '../services/WindGenType4IECService';

class CreateWindGenType4IECComponent extends Component {
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
            WindGenType4IECService.getWindGenType4IECById(this.state.id).then( (res) =>{
                let windGenType4IEC = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateWindGenType4IEC = (e) => {
        e.preventDefault();
        let windGenType4IEC = {
                windGenType4IECId: this.state.id,
            };
        console.log('windGenType4IEC => ' + JSON.stringify(windGenType4IEC));

        // step 5
        if(this.state.id === '_add'){
            windGenType4IEC.windGenType4IECId=''
            WindGenType4IECService.createWindGenType4IEC(windGenType4IEC).then(res =>{
                this.props.history.push('/windGenType4IECs');
            });
        }else{
            WindGenType4IECService.updateWindGenType4IEC(windGenType4IEC).then( res => {
                this.props.history.push('/windGenType4IECs');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/windGenType4IECs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add WindGenType4IEC</h3>
        }else{
            return <h3 className="text-center">Update WindGenType4IEC</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateWindGenType4IEC}>Save</button>
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

export default CreateWindGenType4IECComponent
