import React, { Component } from 'react'
import ExcAVR2Service from '../services/ExcAVR2Service';

class CreateExcAVR2Component extends Component {
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
            ExcAVR2Service.getExcAVR2ById(this.state.id).then( (res) =>{
                let excAVR2 = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateExcAVR2 = (e) => {
        e.preventDefault();
        let excAVR2 = {
                excAVR2Id: this.state.id,
            };
        console.log('excAVR2 => ' + JSON.stringify(excAVR2));

        // step 5
        if(this.state.id === '_add'){
            excAVR2.excAVR2Id=''
            ExcAVR2Service.createExcAVR2(excAVR2).then(res =>{
                this.props.history.push('/excAVR2s');
            });
        }else{
            ExcAVR2Service.updateExcAVR2(excAVR2).then( res => {
                this.props.history.push('/excAVR2s');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/excAVR2s');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ExcAVR2</h3>
        }else{
            return <h3 className="text-center">Update ExcAVR2</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateExcAVR2}>Save</button>
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

export default CreateExcAVR2Component
