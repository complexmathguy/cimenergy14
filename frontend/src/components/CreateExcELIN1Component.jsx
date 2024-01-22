import React, { Component } from 'react'
import ExcELIN1Service from '../services/ExcELIN1Service';

class CreateExcELIN1Component extends Component {
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
            ExcELIN1Service.getExcELIN1ById(this.state.id).then( (res) =>{
                let excELIN1 = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateExcELIN1 = (e) => {
        e.preventDefault();
        let excELIN1 = {
                excELIN1Id: this.state.id,
            };
        console.log('excELIN1 => ' + JSON.stringify(excELIN1));

        // step 5
        if(this.state.id === '_add'){
            excELIN1.excELIN1Id=''
            ExcELIN1Service.createExcELIN1(excELIN1).then(res =>{
                this.props.history.push('/excELIN1s');
            });
        }else{
            ExcELIN1Service.updateExcELIN1(excELIN1).then( res => {
                this.props.history.push('/excELIN1s');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/excELIN1s');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ExcELIN1</h3>
        }else{
            return <h3 className="text-center">Update ExcELIN1</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateExcELIN1}>Save</button>
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

export default CreateExcELIN1Component
