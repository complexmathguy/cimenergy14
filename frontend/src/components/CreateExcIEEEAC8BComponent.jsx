import React, { Component } from 'react'
import ExcIEEEAC8BService from '../services/ExcIEEEAC8BService';

class CreateExcIEEEAC8BComponent extends Component {
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
            ExcIEEEAC8BService.getExcIEEEAC8BById(this.state.id).then( (res) =>{
                let excIEEEAC8B = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateExcIEEEAC8B = (e) => {
        e.preventDefault();
        let excIEEEAC8B = {
                excIEEEAC8BId: this.state.id,
            };
        console.log('excIEEEAC8B => ' + JSON.stringify(excIEEEAC8B));

        // step 5
        if(this.state.id === '_add'){
            excIEEEAC8B.excIEEEAC8BId=''
            ExcIEEEAC8BService.createExcIEEEAC8B(excIEEEAC8B).then(res =>{
                this.props.history.push('/excIEEEAC8Bs');
            });
        }else{
            ExcIEEEAC8BService.updateExcIEEEAC8B(excIEEEAC8B).then( res => {
                this.props.history.push('/excIEEEAC8Bs');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/excIEEEAC8Bs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ExcIEEEAC8B</h3>
        }else{
            return <h3 className="text-center">Update ExcIEEEAC8B</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateExcIEEEAC8B}>Save</button>
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

export default CreateExcIEEEAC8BComponent
