import React, { Component } from 'react'
import TransformerEndService from '../services/TransformerEndService';

class UpdateTransformerEndComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateTransformerEnd = this.updateTransformerEnd.bind(this);

    }

    componentDidMount(){
        TransformerEndService.getTransformerEndById(this.state.id).then( (res) =>{
            let transformerEnd = res.data;
            this.setState({
            });
        });
    }

    updateTransformerEnd = (e) => {
        e.preventDefault();
        let transformerEnd = {
            transformerEndId: this.state.id,
        };
        console.log('transformerEnd => ' + JSON.stringify(transformerEnd));
        console.log('id => ' + JSON.stringify(this.state.id));
        TransformerEndService.updateTransformerEnd(transformerEnd).then( res => {
            this.props.history.push('/transformerEnds');
        });
    }


    cancel(){
        this.props.history.push('/transformerEnds');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update TransformerEnd</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateTransformerEnd}>Save</button>
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

export default UpdateTransformerEndComponent
