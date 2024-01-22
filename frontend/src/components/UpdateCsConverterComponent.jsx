import React, { Component } from 'react'
import CsConverterService from '../services/CsConverterService';

class UpdateCsConverterComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateCsConverter = this.updateCsConverter.bind(this);

    }

    componentDidMount(){
        CsConverterService.getCsConverterById(this.state.id).then( (res) =>{
            let csConverter = res.data;
            this.setState({
            });
        });
    }

    updateCsConverter = (e) => {
        e.preventDefault();
        let csConverter = {
            csConverterId: this.state.id,
        };
        console.log('csConverter => ' + JSON.stringify(csConverter));
        console.log('id => ' + JSON.stringify(this.state.id));
        CsConverterService.updateCsConverter(csConverter).then( res => {
            this.props.history.push('/csConverters');
        });
    }


    cancel(){
        this.props.history.push('/csConverters');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update CsConverter</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateCsConverter}>Save</button>
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

export default UpdateCsConverterComponent
