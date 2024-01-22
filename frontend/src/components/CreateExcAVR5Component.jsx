import React, { Component } from 'react'
import ExcAVR5Service from '../services/ExcAVR5Service';

class CreateExcAVR5Component extends Component {
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
            ExcAVR5Service.getExcAVR5ById(this.state.id).then( (res) =>{
                let excAVR5 = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateExcAVR5 = (e) => {
        e.preventDefault();
        let excAVR5 = {
                excAVR5Id: this.state.id,
            };
        console.log('excAVR5 => ' + JSON.stringify(excAVR5));

        // step 5
        if(this.state.id === '_add'){
            excAVR5.excAVR5Id=''
            ExcAVR5Service.createExcAVR5(excAVR5).then(res =>{
                this.props.history.push('/excAVR5s');
            });
        }else{
            ExcAVR5Service.updateExcAVR5(excAVR5).then( res => {
                this.props.history.push('/excAVR5s');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/excAVR5s');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ExcAVR5</h3>
        }else{
            return <h3 className="text-center">Update ExcAVR5</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateExcAVR5}>Save</button>
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

export default CreateExcAVR5Component
