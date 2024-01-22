/**
 * ***************************************************************************** Turnstone Biologics
 * Confidential
 *
 * <p>2018 Turnstone Biologics All Rights Reserved.
 *
 * <p>This file is subject to the terms and conditions defined in file 'license.txt', which is part
 * of this source code package.
 *
 * <p>Contributors : Turnstone Biologics - General Release
 * ****************************************************************************
 */
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.winddynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.winddynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for WindContPType3IEC as outlined for the CQRS pattern. All event handling and query
 * handling related to WindContPType3IEC are invoked here and dispersed as an event to be handled
 * elsewhere.
 *
 * <p>Commands are handled by WindContPType3IECAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("windContPType3IEC")
@Component("windContPType3IEC-projector")
public class WindContPType3IECProjector extends WindContPType3IECEntityProjector {

  // core constructor
  public WindContPType3IECProjector(
      WindContPType3IECRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateWindContPType3IECEvent
   */
  @EventHandler(payloadType = CreateWindContPType3IECEvent.class)
  public void handle(CreateWindContPType3IECEvent event) {
    LOGGER.info("handling CreateWindContPType3IECEvent - " + event);
    WindContPType3IEC entity = new WindContPType3IEC();
    entity.setWindContPType3IECId(event.getWindContPType3IECId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContPType3IEC(entity);
  }

  /*
   * @param	event UpdateWindContPType3IECEvent
   */
  @EventHandler(payloadType = UpdateWindContPType3IECEvent.class)
  public void handle(UpdateWindContPType3IECEvent event) {
    LOGGER.info("handling UpdateWindContPType3IECEvent - " + event);

    WindContPType3IEC entity = new WindContPType3IEC();
    entity.setWindContPType3IECId(event.getWindContPType3IECId());
    entity.setDpmax(event.getDpmax());
    entity.setDtrisemaxlvrt(event.getDtrisemaxlvrt());
    entity.setKdtd(event.getKdtd());
    entity.setKip(event.getKip());
    entity.setKpp(event.getKpp());
    entity.setMplvrt(event.getMplvrt());
    entity.setOmegaoffset(event.getOmegaoffset());
    entity.setPdtdmax(event.getPdtdmax());
    entity.setRramp(event.getRramp());
    entity.setTdvs(event.getTdvs());
    entity.setTemin(event.getTemin());
    entity.setTomegafilt(event.getTomegafilt());
    entity.setTpfilt(event.getTpfilt());
    entity.setTpord(event.getTpord());
    entity.setTufilt(event.getTufilt());
    entity.setTuscale(event.getTuscale());
    entity.setTwref(event.getTwref());
    entity.setUdvs(event.getUdvs());
    entity.setUpdip(event.getUpdip());
    entity.setWdtd(event.getWdtd());
    entity.setZeta(event.getZeta());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContPType3IEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContPType3IEC(entity);
  }

  /*
   * @param	event DeleteWindContPType3IECEvent
   */
  @EventHandler(payloadType = DeleteWindContPType3IECEvent.class)
  public void handle(DeleteWindContPType3IECEvent event) {
    LOGGER.info("handling DeleteWindContPType3IECEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    WindContPType3IEC entity = delete(event.getWindContPType3IECId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContPType3IEC(entity);
  }

  /*
   * @param	event AssignDpmaxToWindContPType3IECEvent
   */
  @EventHandler(payloadType = AssignDpmaxToWindContPType3IECEvent.class)
  public void handle(AssignDpmaxToWindContPType3IECEvent event) {
    LOGGER.info("handling AssignDpmaxToWindContPType3IECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindContPType3IEC entity = assignDpmax(event.getWindContPType3IECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContPType3IEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContPType3IEC(entity);
  }

  /*
   * @param	event UnAssignDpmaxFromWindContPType3IECEvent
   */
  @EventHandler(payloadType = UnAssignDpmaxFromWindContPType3IECEvent.class)
  public void handle(UnAssignDpmaxFromWindContPType3IECEvent event) {
    LOGGER.info("handling UnAssignDpmaxFromWindContPType3IECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindContPType3IEC entity = unAssignDpmax(event.getWindContPType3IECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContPType3IEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContPType3IEC(entity);
  }

  /*
   * @param	event AssignDtrisemaxlvrtToWindContPType3IECEvent
   */
  @EventHandler(payloadType = AssignDtrisemaxlvrtToWindContPType3IECEvent.class)
  public void handle(AssignDtrisemaxlvrtToWindContPType3IECEvent event) {
    LOGGER.info("handling AssignDtrisemaxlvrtToWindContPType3IECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindContPType3IEC entity =
        assignDtrisemaxlvrt(event.getWindContPType3IECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContPType3IEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContPType3IEC(entity);
  }

  /*
   * @param	event UnAssignDtrisemaxlvrtFromWindContPType3IECEvent
   */
  @EventHandler(payloadType = UnAssignDtrisemaxlvrtFromWindContPType3IECEvent.class)
  public void handle(UnAssignDtrisemaxlvrtFromWindContPType3IECEvent event) {
    LOGGER.info("handling UnAssignDtrisemaxlvrtFromWindContPType3IECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindContPType3IEC entity = unAssignDtrisemaxlvrt(event.getWindContPType3IECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContPType3IEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContPType3IEC(entity);
  }

  /*
   * @param	event AssignKdtdToWindContPType3IECEvent
   */
  @EventHandler(payloadType = AssignKdtdToWindContPType3IECEvent.class)
  public void handle(AssignKdtdToWindContPType3IECEvent event) {
    LOGGER.info("handling AssignKdtdToWindContPType3IECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindContPType3IEC entity = assignKdtd(event.getWindContPType3IECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContPType3IEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContPType3IEC(entity);
  }

  /*
   * @param	event UnAssignKdtdFromWindContPType3IECEvent
   */
  @EventHandler(payloadType = UnAssignKdtdFromWindContPType3IECEvent.class)
  public void handle(UnAssignKdtdFromWindContPType3IECEvent event) {
    LOGGER.info("handling UnAssignKdtdFromWindContPType3IECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindContPType3IEC entity = unAssignKdtd(event.getWindContPType3IECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContPType3IEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContPType3IEC(entity);
  }

  /*
   * @param	event AssignKipToWindContPType3IECEvent
   */
  @EventHandler(payloadType = AssignKipToWindContPType3IECEvent.class)
  public void handle(AssignKipToWindContPType3IECEvent event) {
    LOGGER.info("handling AssignKipToWindContPType3IECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindContPType3IEC entity = assignKip(event.getWindContPType3IECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContPType3IEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContPType3IEC(entity);
  }

  /*
   * @param	event UnAssignKipFromWindContPType3IECEvent
   */
  @EventHandler(payloadType = UnAssignKipFromWindContPType3IECEvent.class)
  public void handle(UnAssignKipFromWindContPType3IECEvent event) {
    LOGGER.info("handling UnAssignKipFromWindContPType3IECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindContPType3IEC entity = unAssignKip(event.getWindContPType3IECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContPType3IEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContPType3IEC(entity);
  }

  /*
   * @param	event AssignKppToWindContPType3IECEvent
   */
  @EventHandler(payloadType = AssignKppToWindContPType3IECEvent.class)
  public void handle(AssignKppToWindContPType3IECEvent event) {
    LOGGER.info("handling AssignKppToWindContPType3IECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindContPType3IEC entity = assignKpp(event.getWindContPType3IECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContPType3IEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContPType3IEC(entity);
  }

  /*
   * @param	event UnAssignKppFromWindContPType3IECEvent
   */
  @EventHandler(payloadType = UnAssignKppFromWindContPType3IECEvent.class)
  public void handle(UnAssignKppFromWindContPType3IECEvent event) {
    LOGGER.info("handling UnAssignKppFromWindContPType3IECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindContPType3IEC entity = unAssignKpp(event.getWindContPType3IECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContPType3IEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContPType3IEC(entity);
  }

  /*
   * @param	event AssignMplvrtToWindContPType3IECEvent
   */
  @EventHandler(payloadType = AssignMplvrtToWindContPType3IECEvent.class)
  public void handle(AssignMplvrtToWindContPType3IECEvent event) {
    LOGGER.info("handling AssignMplvrtToWindContPType3IECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindContPType3IEC entity = assignMplvrt(event.getWindContPType3IECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContPType3IEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContPType3IEC(entity);
  }

  /*
   * @param	event UnAssignMplvrtFromWindContPType3IECEvent
   */
  @EventHandler(payloadType = UnAssignMplvrtFromWindContPType3IECEvent.class)
  public void handle(UnAssignMplvrtFromWindContPType3IECEvent event) {
    LOGGER.info("handling UnAssignMplvrtFromWindContPType3IECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindContPType3IEC entity = unAssignMplvrt(event.getWindContPType3IECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContPType3IEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContPType3IEC(entity);
  }

  /*
   * @param	event AssignOmegaoffsetToWindContPType3IECEvent
   */
  @EventHandler(payloadType = AssignOmegaoffsetToWindContPType3IECEvent.class)
  public void handle(AssignOmegaoffsetToWindContPType3IECEvent event) {
    LOGGER.info("handling AssignOmegaoffsetToWindContPType3IECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindContPType3IEC entity =
        assignOmegaoffset(event.getWindContPType3IECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContPType3IEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContPType3IEC(entity);
  }

  /*
   * @param	event UnAssignOmegaoffsetFromWindContPType3IECEvent
   */
  @EventHandler(payloadType = UnAssignOmegaoffsetFromWindContPType3IECEvent.class)
  public void handle(UnAssignOmegaoffsetFromWindContPType3IECEvent event) {
    LOGGER.info("handling UnAssignOmegaoffsetFromWindContPType3IECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindContPType3IEC entity = unAssignOmegaoffset(event.getWindContPType3IECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContPType3IEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContPType3IEC(entity);
  }

  /*
   * @param	event AssignPdtdmaxToWindContPType3IECEvent
   */
  @EventHandler(payloadType = AssignPdtdmaxToWindContPType3IECEvent.class)
  public void handle(AssignPdtdmaxToWindContPType3IECEvent event) {
    LOGGER.info("handling AssignPdtdmaxToWindContPType3IECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindContPType3IEC entity = assignPdtdmax(event.getWindContPType3IECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContPType3IEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContPType3IEC(entity);
  }

  /*
   * @param	event UnAssignPdtdmaxFromWindContPType3IECEvent
   */
  @EventHandler(payloadType = UnAssignPdtdmaxFromWindContPType3IECEvent.class)
  public void handle(UnAssignPdtdmaxFromWindContPType3IECEvent event) {
    LOGGER.info("handling UnAssignPdtdmaxFromWindContPType3IECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindContPType3IEC entity = unAssignPdtdmax(event.getWindContPType3IECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContPType3IEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContPType3IEC(entity);
  }

  /*
   * @param	event AssignRrampToWindContPType3IECEvent
   */
  @EventHandler(payloadType = AssignRrampToWindContPType3IECEvent.class)
  public void handle(AssignRrampToWindContPType3IECEvent event) {
    LOGGER.info("handling AssignRrampToWindContPType3IECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindContPType3IEC entity = assignRramp(event.getWindContPType3IECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContPType3IEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContPType3IEC(entity);
  }

  /*
   * @param	event UnAssignRrampFromWindContPType3IECEvent
   */
  @EventHandler(payloadType = UnAssignRrampFromWindContPType3IECEvent.class)
  public void handle(UnAssignRrampFromWindContPType3IECEvent event) {
    LOGGER.info("handling UnAssignRrampFromWindContPType3IECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindContPType3IEC entity = unAssignRramp(event.getWindContPType3IECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContPType3IEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContPType3IEC(entity);
  }

  /*
   * @param	event AssignTdvsToWindContPType3IECEvent
   */
  @EventHandler(payloadType = AssignTdvsToWindContPType3IECEvent.class)
  public void handle(AssignTdvsToWindContPType3IECEvent event) {
    LOGGER.info("handling AssignTdvsToWindContPType3IECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindContPType3IEC entity = assignTdvs(event.getWindContPType3IECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContPType3IEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContPType3IEC(entity);
  }

  /*
   * @param	event UnAssignTdvsFromWindContPType3IECEvent
   */
  @EventHandler(payloadType = UnAssignTdvsFromWindContPType3IECEvent.class)
  public void handle(UnAssignTdvsFromWindContPType3IECEvent event) {
    LOGGER.info("handling UnAssignTdvsFromWindContPType3IECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindContPType3IEC entity = unAssignTdvs(event.getWindContPType3IECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContPType3IEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContPType3IEC(entity);
  }

  /*
   * @param	event AssignTeminToWindContPType3IECEvent
   */
  @EventHandler(payloadType = AssignTeminToWindContPType3IECEvent.class)
  public void handle(AssignTeminToWindContPType3IECEvent event) {
    LOGGER.info("handling AssignTeminToWindContPType3IECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindContPType3IEC entity = assignTemin(event.getWindContPType3IECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContPType3IEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContPType3IEC(entity);
  }

  /*
   * @param	event UnAssignTeminFromWindContPType3IECEvent
   */
  @EventHandler(payloadType = UnAssignTeminFromWindContPType3IECEvent.class)
  public void handle(UnAssignTeminFromWindContPType3IECEvent event) {
    LOGGER.info("handling UnAssignTeminFromWindContPType3IECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindContPType3IEC entity = unAssignTemin(event.getWindContPType3IECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContPType3IEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContPType3IEC(entity);
  }

  /*
   * @param	event AssignTomegafiltToWindContPType3IECEvent
   */
  @EventHandler(payloadType = AssignTomegafiltToWindContPType3IECEvent.class)
  public void handle(AssignTomegafiltToWindContPType3IECEvent event) {
    LOGGER.info("handling AssignTomegafiltToWindContPType3IECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindContPType3IEC entity =
        assignTomegafilt(event.getWindContPType3IECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContPType3IEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContPType3IEC(entity);
  }

  /*
   * @param	event UnAssignTomegafiltFromWindContPType3IECEvent
   */
  @EventHandler(payloadType = UnAssignTomegafiltFromWindContPType3IECEvent.class)
  public void handle(UnAssignTomegafiltFromWindContPType3IECEvent event) {
    LOGGER.info("handling UnAssignTomegafiltFromWindContPType3IECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindContPType3IEC entity = unAssignTomegafilt(event.getWindContPType3IECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContPType3IEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContPType3IEC(entity);
  }

  /*
   * @param	event AssignTpfiltToWindContPType3IECEvent
   */
  @EventHandler(payloadType = AssignTpfiltToWindContPType3IECEvent.class)
  public void handle(AssignTpfiltToWindContPType3IECEvent event) {
    LOGGER.info("handling AssignTpfiltToWindContPType3IECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindContPType3IEC entity = assignTpfilt(event.getWindContPType3IECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContPType3IEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContPType3IEC(entity);
  }

  /*
   * @param	event UnAssignTpfiltFromWindContPType3IECEvent
   */
  @EventHandler(payloadType = UnAssignTpfiltFromWindContPType3IECEvent.class)
  public void handle(UnAssignTpfiltFromWindContPType3IECEvent event) {
    LOGGER.info("handling UnAssignTpfiltFromWindContPType3IECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindContPType3IEC entity = unAssignTpfilt(event.getWindContPType3IECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContPType3IEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContPType3IEC(entity);
  }

  /*
   * @param	event AssignTpordToWindContPType3IECEvent
   */
  @EventHandler(payloadType = AssignTpordToWindContPType3IECEvent.class)
  public void handle(AssignTpordToWindContPType3IECEvent event) {
    LOGGER.info("handling AssignTpordToWindContPType3IECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindContPType3IEC entity = assignTpord(event.getWindContPType3IECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContPType3IEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContPType3IEC(entity);
  }

  /*
   * @param	event UnAssignTpordFromWindContPType3IECEvent
   */
  @EventHandler(payloadType = UnAssignTpordFromWindContPType3IECEvent.class)
  public void handle(UnAssignTpordFromWindContPType3IECEvent event) {
    LOGGER.info("handling UnAssignTpordFromWindContPType3IECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindContPType3IEC entity = unAssignTpord(event.getWindContPType3IECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContPType3IEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContPType3IEC(entity);
  }

  /*
   * @param	event AssignTufiltToWindContPType3IECEvent
   */
  @EventHandler(payloadType = AssignTufiltToWindContPType3IECEvent.class)
  public void handle(AssignTufiltToWindContPType3IECEvent event) {
    LOGGER.info("handling AssignTufiltToWindContPType3IECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindContPType3IEC entity = assignTufilt(event.getWindContPType3IECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContPType3IEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContPType3IEC(entity);
  }

  /*
   * @param	event UnAssignTufiltFromWindContPType3IECEvent
   */
  @EventHandler(payloadType = UnAssignTufiltFromWindContPType3IECEvent.class)
  public void handle(UnAssignTufiltFromWindContPType3IECEvent event) {
    LOGGER.info("handling UnAssignTufiltFromWindContPType3IECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindContPType3IEC entity = unAssignTufilt(event.getWindContPType3IECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContPType3IEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContPType3IEC(entity);
  }

  /*
   * @param	event AssignTuscaleToWindContPType3IECEvent
   */
  @EventHandler(payloadType = AssignTuscaleToWindContPType3IECEvent.class)
  public void handle(AssignTuscaleToWindContPType3IECEvent event) {
    LOGGER.info("handling AssignTuscaleToWindContPType3IECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindContPType3IEC entity = assignTuscale(event.getWindContPType3IECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContPType3IEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContPType3IEC(entity);
  }

  /*
   * @param	event UnAssignTuscaleFromWindContPType3IECEvent
   */
  @EventHandler(payloadType = UnAssignTuscaleFromWindContPType3IECEvent.class)
  public void handle(UnAssignTuscaleFromWindContPType3IECEvent event) {
    LOGGER.info("handling UnAssignTuscaleFromWindContPType3IECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindContPType3IEC entity = unAssignTuscale(event.getWindContPType3IECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContPType3IEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContPType3IEC(entity);
  }

  /*
   * @param	event AssignTwrefToWindContPType3IECEvent
   */
  @EventHandler(payloadType = AssignTwrefToWindContPType3IECEvent.class)
  public void handle(AssignTwrefToWindContPType3IECEvent event) {
    LOGGER.info("handling AssignTwrefToWindContPType3IECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindContPType3IEC entity = assignTwref(event.getWindContPType3IECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContPType3IEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContPType3IEC(entity);
  }

  /*
   * @param	event UnAssignTwrefFromWindContPType3IECEvent
   */
  @EventHandler(payloadType = UnAssignTwrefFromWindContPType3IECEvent.class)
  public void handle(UnAssignTwrefFromWindContPType3IECEvent event) {
    LOGGER.info("handling UnAssignTwrefFromWindContPType3IECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindContPType3IEC entity = unAssignTwref(event.getWindContPType3IECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContPType3IEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContPType3IEC(entity);
  }

  /*
   * @param	event AssignUdvsToWindContPType3IECEvent
   */
  @EventHandler(payloadType = AssignUdvsToWindContPType3IECEvent.class)
  public void handle(AssignUdvsToWindContPType3IECEvent event) {
    LOGGER.info("handling AssignUdvsToWindContPType3IECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindContPType3IEC entity = assignUdvs(event.getWindContPType3IECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContPType3IEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContPType3IEC(entity);
  }

  /*
   * @param	event UnAssignUdvsFromWindContPType3IECEvent
   */
  @EventHandler(payloadType = UnAssignUdvsFromWindContPType3IECEvent.class)
  public void handle(UnAssignUdvsFromWindContPType3IECEvent event) {
    LOGGER.info("handling UnAssignUdvsFromWindContPType3IECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindContPType3IEC entity = unAssignUdvs(event.getWindContPType3IECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContPType3IEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContPType3IEC(entity);
  }

  /*
   * @param	event AssignUpdipToWindContPType3IECEvent
   */
  @EventHandler(payloadType = AssignUpdipToWindContPType3IECEvent.class)
  public void handle(AssignUpdipToWindContPType3IECEvent event) {
    LOGGER.info("handling AssignUpdipToWindContPType3IECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindContPType3IEC entity = assignUpdip(event.getWindContPType3IECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContPType3IEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContPType3IEC(entity);
  }

  /*
   * @param	event UnAssignUpdipFromWindContPType3IECEvent
   */
  @EventHandler(payloadType = UnAssignUpdipFromWindContPType3IECEvent.class)
  public void handle(UnAssignUpdipFromWindContPType3IECEvent event) {
    LOGGER.info("handling UnAssignUpdipFromWindContPType3IECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindContPType3IEC entity = unAssignUpdip(event.getWindContPType3IECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContPType3IEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContPType3IEC(entity);
  }

  /*
   * @param	event AssignWdtdToWindContPType3IECEvent
   */
  @EventHandler(payloadType = AssignWdtdToWindContPType3IECEvent.class)
  public void handle(AssignWdtdToWindContPType3IECEvent event) {
    LOGGER.info("handling AssignWdtdToWindContPType3IECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindContPType3IEC entity = assignWdtd(event.getWindContPType3IECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContPType3IEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContPType3IEC(entity);
  }

  /*
   * @param	event UnAssignWdtdFromWindContPType3IECEvent
   */
  @EventHandler(payloadType = UnAssignWdtdFromWindContPType3IECEvent.class)
  public void handle(UnAssignWdtdFromWindContPType3IECEvent event) {
    LOGGER.info("handling UnAssignWdtdFromWindContPType3IECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindContPType3IEC entity = unAssignWdtd(event.getWindContPType3IECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContPType3IEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContPType3IEC(entity);
  }

  /*
   * @param	event AssignZetaToWindContPType3IECEvent
   */
  @EventHandler(payloadType = AssignZetaToWindContPType3IECEvent.class)
  public void handle(AssignZetaToWindContPType3IECEvent event) {
    LOGGER.info("handling AssignZetaToWindContPType3IECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindContPType3IEC entity = assignZeta(event.getWindContPType3IECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContPType3IEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContPType3IEC(entity);
  }

  /*
   * @param	event UnAssignZetaFromWindContPType3IECEvent
   */
  @EventHandler(payloadType = UnAssignZetaFromWindContPType3IECEvent.class)
  public void handle(UnAssignZetaFromWindContPType3IECEvent event) {
    LOGGER.info("handling UnAssignZetaFromWindContPType3IECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindContPType3IEC entity = unAssignZeta(event.getWindContPType3IECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindContPType3IEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindContPType3IEC(entity);
  }

  /**
   * Method to retrieve the WindContPType3IEC via an WindContPType3IECPrimaryKey.
   *
   * @param id Long
   * @return WindContPType3IEC
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public WindContPType3IEC handle(FindWindContPType3IECQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getWindContPType3IECId());
  }

  /**
   * Method to retrieve a collection of all WindContPType3IECs
   *
   * @param query FindAllWindContPType3IECQuery
   * @return List<WindContPType3IEC>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<WindContPType3IEC> handle(FindAllWindContPType3IECQuery query)
      throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindWindContPType3IEC, but only if the id matches
   *
   * @param entity WindContPType3IEC
   */
  protected void emitFindWindContPType3IEC(WindContPType3IEC entity) {
    LOGGER.info("handling emitFindWindContPType3IEC");

    queryUpdateEmitter.emit(
        FindWindContPType3IECQuery.class,
        query -> query.getFilter().getWindContPType3IECId().equals(entity.getWindContPType3IECId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllWindContPType3IEC
   *
   * @param entity WindContPType3IEC
   */
  protected void emitFindAllWindContPType3IEC(WindContPType3IEC entity) {
    LOGGER.info("handling emitFindAllWindContPType3IEC");

    queryUpdateEmitter.emit(FindAllWindContPType3IECQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(WindContPType3IECProjector.class.getName());
}
