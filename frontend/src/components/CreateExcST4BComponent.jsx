import React, { Component } from 'react'
import ExcST4BService from '../services/ExcST4BService';

class CreateExcST4BComponent extends Component {
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
            ExcST4BService.getExcST4BById(this.state.id).then( (res) =>{
                let excST4B = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateExcST4B = (e) => {
        e.preventDefault();
        let excST4B = {
                excST4BId: this.state.id,
            };
        console.log('excST4B => ' + JSON.stringify(excST4B));

        // step 5
        if(this.state.id === '_add'){
            excST4B.excST4BId=''
            ExcST4BService.createExcST4B(excST4B).then(res =>{
                this.props.history.push('/excST4Bs');
            });
        }else{
            ExcST4BService.updateExcST4B(excST4B).then( res => {
                this.props.history.push('/excST4Bs');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/excST4Bs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ExcST4B</h3>
        }else{
            return <h3 className="text-center">Update ExcST4B</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateExcST4B}>Save</button>
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

export default CreateExcST4BComponent
