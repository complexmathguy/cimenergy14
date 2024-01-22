import React, { Component } from 'react'
import TransformerEndService from '../services/TransformerEndService';

class CreateTransformerEndComponent extends Component {
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
            TransformerEndService.getTransformerEndById(this.state.id).then( (res) =>{
                let transformerEnd = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateTransformerEnd = (e) => {
        e.preventDefault();
        let transformerEnd = {
                transformerEndId: this.state.id,
            };
        console.log('transformerEnd => ' + JSON.stringify(transformerEnd));

        // step 5
        if(this.state.id === '_add'){
            transformerEnd.transformerEndId=''
            TransformerEndService.createTransformerEnd(transformerEnd).then(res =>{
                this.props.history.push('/transformerEnds');
            });
        }else{
            TransformerEndService.updateTransformerEnd(transformerEnd).then( res => {
                this.props.history.push('/transformerEnds');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/transformerEnds');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add TransformerEnd</h3>
        }else{
            return <h3 className="text-center">Update TransformerEnd</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateTransformerEnd}>Save</button>
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

export default CreateTransformerEndComponent
