import React, { Component } from 'react'
import ExcAVR3Service from '../services/ExcAVR3Service';

class CreateExcAVR3Component extends Component {
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
            ExcAVR3Service.getExcAVR3ById(this.state.id).then( (res) =>{
                let excAVR3 = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateExcAVR3 = (e) => {
        e.preventDefault();
        let excAVR3 = {
                excAVR3Id: this.state.id,
            };
        console.log('excAVR3 => ' + JSON.stringify(excAVR3));

        // step 5
        if(this.state.id === '_add'){
            excAVR3.excAVR3Id=''
            ExcAVR3Service.createExcAVR3(excAVR3).then(res =>{
                this.props.history.push('/excAVR3s');
            });
        }else{
            ExcAVR3Service.updateExcAVR3(excAVR3).then( res => {
                this.props.history.push('/excAVR3s');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/excAVR3s');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ExcAVR3</h3>
        }else{
            return <h3 className="text-center">Update ExcAVR3</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateExcAVR3}>Save</button>
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

export default CreateExcAVR3Component
