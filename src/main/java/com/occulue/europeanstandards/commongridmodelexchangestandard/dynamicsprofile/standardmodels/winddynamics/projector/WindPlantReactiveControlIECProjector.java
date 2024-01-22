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
 * Projector for WindPlantReactiveControlIEC as outlined for the CQRS pattern. All event handling
 * and query handling related to WindPlantReactiveControlIEC are invoked here and dispersed as an
 * event to be handled elsewhere.
 *
 * <p>Commands are handled by WindPlantReactiveControlIECAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("windPlantReactiveControlIEC")
@Component("windPlantReactiveControlIEC-projector")
public class WindPlantReactiveControlIECProjector
    extends WindPlantReactiveControlIECEntityProjector {

  // core constructor
  public WindPlantReactiveControlIECProjector(
      WindPlantReactiveControlIECRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateWindPlantReactiveControlIECEvent
   */
  @EventHandler(payloadType = CreateWindPlantReactiveControlIECEvent.class)
  public void handle(CreateWindPlantReactiveControlIECEvent event) {
    LOGGER.info("handling CreateWindPlantReactiveControlIECEvent - " + event);
    WindPlantReactiveControlIEC entity = new WindPlantReactiveControlIEC();
    entity.setWindPlantReactiveControlIECId(event.getWindPlantReactiveControlIECId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindPlantReactiveControlIEC(entity);
  }

  /*
   * @param	event UpdateWindPlantReactiveControlIECEvent
   */
  @EventHandler(payloadType = UpdateWindPlantReactiveControlIECEvent.class)
  public void handle(UpdateWindPlantReactiveControlIECEvent event) {
    LOGGER.info("handling UpdateWindPlantReactiveControlIECEvent - " + event);

    WindPlantReactiveControlIEC entity = new WindPlantReactiveControlIEC();
    entity.setWindPlantReactiveControlIECId(event.getWindPlantReactiveControlIECId());
    entity.setKiwpx(event.getKiwpx());
    entity.setKpwpx(event.getKpwpx());
    entity.setKwpqu(event.getKwpqu());
    entity.setMwppf(event.getMwppf());
    entity.setMwpu(event.getMwpu());
    entity.setTwppfilt(event.getTwppfilt());
    entity.setTwpqfilt(event.getTwpqfilt());
    entity.setTwpufilt(event.getTwpufilt());
    entity.setTxft(event.getTxft());
    entity.setTxfv(event.getTxfv());
    entity.setUwpqdip(event.getUwpqdip());
    entity.setXrefmax(event.getXrefmax());
    entity.setXrefmin(event.getXrefmin());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindPlantReactiveControlIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindPlantReactiveControlIEC(entity);
  }

  /*
   * @param	event DeleteWindPlantReactiveControlIECEvent
   */
  @EventHandler(payloadType = DeleteWindPlantReactiveControlIECEvent.class)
  public void handle(DeleteWindPlantReactiveControlIECEvent event) {
    LOGGER.info("handling DeleteWindPlantReactiveControlIECEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    WindPlantReactiveControlIEC entity = delete(event.getWindPlantReactiveControlIECId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindPlantReactiveControlIEC(entity);
  }

  /*
   * @param	event AssignKiwpxToWindPlantReactiveControlIECEvent
   */
  @EventHandler(payloadType = AssignKiwpxToWindPlantReactiveControlIECEvent.class)
  public void handle(AssignKiwpxToWindPlantReactiveControlIECEvent event) {
    LOGGER.info("handling AssignKiwpxToWindPlantReactiveControlIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindPlantReactiveControlIEC entity =
        assignKiwpx(event.getWindPlantReactiveControlIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindPlantReactiveControlIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindPlantReactiveControlIEC(entity);
  }

  /*
   * @param	event UnAssignKiwpxFromWindPlantReactiveControlIECEvent
   */
  @EventHandler(payloadType = UnAssignKiwpxFromWindPlantReactiveControlIECEvent.class)
  public void handle(UnAssignKiwpxFromWindPlantReactiveControlIECEvent event) {
    LOGGER.info("handling UnAssignKiwpxFromWindPlantReactiveControlIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindPlantReactiveControlIEC entity = unAssignKiwpx(event.getWindPlantReactiveControlIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindPlantReactiveControlIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindPlantReactiveControlIEC(entity);
  }

  /*
   * @param	event AssignKpwpxToWindPlantReactiveControlIECEvent
   */
  @EventHandler(payloadType = AssignKpwpxToWindPlantReactiveControlIECEvent.class)
  public void handle(AssignKpwpxToWindPlantReactiveControlIECEvent event) {
    LOGGER.info("handling AssignKpwpxToWindPlantReactiveControlIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindPlantReactiveControlIEC entity =
        assignKpwpx(event.getWindPlantReactiveControlIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindPlantReactiveControlIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindPlantReactiveControlIEC(entity);
  }

  /*
   * @param	event UnAssignKpwpxFromWindPlantReactiveControlIECEvent
   */
  @EventHandler(payloadType = UnAssignKpwpxFromWindPlantReactiveControlIECEvent.class)
  public void handle(UnAssignKpwpxFromWindPlantReactiveControlIECEvent event) {
    LOGGER.info("handling UnAssignKpwpxFromWindPlantReactiveControlIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindPlantReactiveControlIEC entity = unAssignKpwpx(event.getWindPlantReactiveControlIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindPlantReactiveControlIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindPlantReactiveControlIEC(entity);
  }

  /*
   * @param	event AssignKwpquToWindPlantReactiveControlIECEvent
   */
  @EventHandler(payloadType = AssignKwpquToWindPlantReactiveControlIECEvent.class)
  public void handle(AssignKwpquToWindPlantReactiveControlIECEvent event) {
    LOGGER.info("handling AssignKwpquToWindPlantReactiveControlIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindPlantReactiveControlIEC entity =
        assignKwpqu(event.getWindPlantReactiveControlIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindPlantReactiveControlIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindPlantReactiveControlIEC(entity);
  }

  /*
   * @param	event UnAssignKwpquFromWindPlantReactiveControlIECEvent
   */
  @EventHandler(payloadType = UnAssignKwpquFromWindPlantReactiveControlIECEvent.class)
  public void handle(UnAssignKwpquFromWindPlantReactiveControlIECEvent event) {
    LOGGER.info("handling UnAssignKwpquFromWindPlantReactiveControlIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindPlantReactiveControlIEC entity = unAssignKwpqu(event.getWindPlantReactiveControlIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindPlantReactiveControlIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindPlantReactiveControlIEC(entity);
  }

  /*
   * @param	event AssignMwppfToWindPlantReactiveControlIECEvent
   */
  @EventHandler(payloadType = AssignMwppfToWindPlantReactiveControlIECEvent.class)
  public void handle(AssignMwppfToWindPlantReactiveControlIECEvent event) {
    LOGGER.info("handling AssignMwppfToWindPlantReactiveControlIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindPlantReactiveControlIEC entity =
        assignMwppf(event.getWindPlantReactiveControlIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindPlantReactiveControlIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindPlantReactiveControlIEC(entity);
  }

  /*
   * @param	event UnAssignMwppfFromWindPlantReactiveControlIECEvent
   */
  @EventHandler(payloadType = UnAssignMwppfFromWindPlantReactiveControlIECEvent.class)
  public void handle(UnAssignMwppfFromWindPlantReactiveControlIECEvent event) {
    LOGGER.info("handling UnAssignMwppfFromWindPlantReactiveControlIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindPlantReactiveControlIEC entity = unAssignMwppf(event.getWindPlantReactiveControlIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindPlantReactiveControlIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindPlantReactiveControlIEC(entity);
  }

  /*
   * @param	event AssignMwpuToWindPlantReactiveControlIECEvent
   */
  @EventHandler(payloadType = AssignMwpuToWindPlantReactiveControlIECEvent.class)
  public void handle(AssignMwpuToWindPlantReactiveControlIECEvent event) {
    LOGGER.info("handling AssignMwpuToWindPlantReactiveControlIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindPlantReactiveControlIEC entity =
        assignMwpu(event.getWindPlantReactiveControlIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindPlantReactiveControlIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindPlantReactiveControlIEC(entity);
  }

  /*
   * @param	event UnAssignMwpuFromWindPlantReactiveControlIECEvent
   */
  @EventHandler(payloadType = UnAssignMwpuFromWindPlantReactiveControlIECEvent.class)
  public void handle(UnAssignMwpuFromWindPlantReactiveControlIECEvent event) {
    LOGGER.info("handling UnAssignMwpuFromWindPlantReactiveControlIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindPlantReactiveControlIEC entity = unAssignMwpu(event.getWindPlantReactiveControlIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindPlantReactiveControlIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindPlantReactiveControlIEC(entity);
  }

  /*
   * @param	event AssignTwppfiltToWindPlantReactiveControlIECEvent
   */
  @EventHandler(payloadType = AssignTwppfiltToWindPlantReactiveControlIECEvent.class)
  public void handle(AssignTwppfiltToWindPlantReactiveControlIECEvent event) {
    LOGGER.info("handling AssignTwppfiltToWindPlantReactiveControlIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindPlantReactiveControlIEC entity =
        assignTwppfilt(event.getWindPlantReactiveControlIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindPlantReactiveControlIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindPlantReactiveControlIEC(entity);
  }

  /*
   * @param	event UnAssignTwppfiltFromWindPlantReactiveControlIECEvent
   */
  @EventHandler(payloadType = UnAssignTwppfiltFromWindPlantReactiveControlIECEvent.class)
  public void handle(UnAssignTwppfiltFromWindPlantReactiveControlIECEvent event) {
    LOGGER.info("handling UnAssignTwppfiltFromWindPlantReactiveControlIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindPlantReactiveControlIEC entity = unAssignTwppfilt(event.getWindPlantReactiveControlIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindPlantReactiveControlIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindPlantReactiveControlIEC(entity);
  }

  /*
   * @param	event AssignTwpqfiltToWindPlantReactiveControlIECEvent
   */
  @EventHandler(payloadType = AssignTwpqfiltToWindPlantReactiveControlIECEvent.class)
  public void handle(AssignTwpqfiltToWindPlantReactiveControlIECEvent event) {
    LOGGER.info("handling AssignTwpqfiltToWindPlantReactiveControlIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindPlantReactiveControlIEC entity =
        assignTwpqfilt(event.getWindPlantReactiveControlIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindPlantReactiveControlIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindPlantReactiveControlIEC(entity);
  }

  /*
   * @param	event UnAssignTwpqfiltFromWindPlantReactiveControlIECEvent
   */
  @EventHandler(payloadType = UnAssignTwpqfiltFromWindPlantReactiveControlIECEvent.class)
  public void handle(UnAssignTwpqfiltFromWindPlantReactiveControlIECEvent event) {
    LOGGER.info("handling UnAssignTwpqfiltFromWindPlantReactiveControlIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindPlantReactiveControlIEC entity = unAssignTwpqfilt(event.getWindPlantReactiveControlIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindPlantReactiveControlIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindPlantReactiveControlIEC(entity);
  }

  /*
   * @param	event AssignTwpufiltToWindPlantReactiveControlIECEvent
   */
  @EventHandler(payloadType = AssignTwpufiltToWindPlantReactiveControlIECEvent.class)
  public void handle(AssignTwpufiltToWindPlantReactiveControlIECEvent event) {
    LOGGER.info("handling AssignTwpufiltToWindPlantReactiveControlIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindPlantReactiveControlIEC entity =
        assignTwpufilt(event.getWindPlantReactiveControlIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindPlantReactiveControlIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindPlantReactiveControlIEC(entity);
  }

  /*
   * @param	event UnAssignTwpufiltFromWindPlantReactiveControlIECEvent
   */
  @EventHandler(payloadType = UnAssignTwpufiltFromWindPlantReactiveControlIECEvent.class)
  public void handle(UnAssignTwpufiltFromWindPlantReactiveControlIECEvent event) {
    LOGGER.info("handling UnAssignTwpufiltFromWindPlantReactiveControlIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindPlantReactiveControlIEC entity = unAssignTwpufilt(event.getWindPlantReactiveControlIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindPlantReactiveControlIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindPlantReactiveControlIEC(entity);
  }

  /*
   * @param	event AssignTxftToWindPlantReactiveControlIECEvent
   */
  @EventHandler(payloadType = AssignTxftToWindPlantReactiveControlIECEvent.class)
  public void handle(AssignTxftToWindPlantReactiveControlIECEvent event) {
    LOGGER.info("handling AssignTxftToWindPlantReactiveControlIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindPlantReactiveControlIEC entity =
        assignTxft(event.getWindPlantReactiveControlIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindPlantReactiveControlIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindPlantReactiveControlIEC(entity);
  }

  /*
   * @param	event UnAssignTxftFromWindPlantReactiveControlIECEvent
   */
  @EventHandler(payloadType = UnAssignTxftFromWindPlantReactiveControlIECEvent.class)
  public void handle(UnAssignTxftFromWindPlantReactiveControlIECEvent event) {
    LOGGER.info("handling UnAssignTxftFromWindPlantReactiveControlIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindPlantReactiveControlIEC entity = unAssignTxft(event.getWindPlantReactiveControlIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindPlantReactiveControlIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindPlantReactiveControlIEC(entity);
  }

  /*
   * @param	event AssignTxfvToWindPlantReactiveControlIECEvent
   */
  @EventHandler(payloadType = AssignTxfvToWindPlantReactiveControlIECEvent.class)
  public void handle(AssignTxfvToWindPlantReactiveControlIECEvent event) {
    LOGGER.info("handling AssignTxfvToWindPlantReactiveControlIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindPlantReactiveControlIEC entity =
        assignTxfv(event.getWindPlantReactiveControlIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindPlantReactiveControlIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindPlantReactiveControlIEC(entity);
  }

  /*
   * @param	event UnAssignTxfvFromWindPlantReactiveControlIECEvent
   */
  @EventHandler(payloadType = UnAssignTxfvFromWindPlantReactiveControlIECEvent.class)
  public void handle(UnAssignTxfvFromWindPlantReactiveControlIECEvent event) {
    LOGGER.info("handling UnAssignTxfvFromWindPlantReactiveControlIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindPlantReactiveControlIEC entity = unAssignTxfv(event.getWindPlantReactiveControlIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindPlantReactiveControlIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindPlantReactiveControlIEC(entity);
  }

  /*
   * @param	event AssignUwpqdipToWindPlantReactiveControlIECEvent
   */
  @EventHandler(payloadType = AssignUwpqdipToWindPlantReactiveControlIECEvent.class)
  public void handle(AssignUwpqdipToWindPlantReactiveControlIECEvent event) {
    LOGGER.info("handling AssignUwpqdipToWindPlantReactiveControlIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindPlantReactiveControlIEC entity =
        assignUwpqdip(event.getWindPlantReactiveControlIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindPlantReactiveControlIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindPlantReactiveControlIEC(entity);
  }

  /*
   * @param	event UnAssignUwpqdipFromWindPlantReactiveControlIECEvent
   */
  @EventHandler(payloadType = UnAssignUwpqdipFromWindPlantReactiveControlIECEvent.class)
  public void handle(UnAssignUwpqdipFromWindPlantReactiveControlIECEvent event) {
    LOGGER.info("handling UnAssignUwpqdipFromWindPlantReactiveControlIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindPlantReactiveControlIEC entity = unAssignUwpqdip(event.getWindPlantReactiveControlIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindPlantReactiveControlIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindPlantReactiveControlIEC(entity);
  }

  /*
   * @param	event AssignXrefmaxToWindPlantReactiveControlIECEvent
   */
  @EventHandler(payloadType = AssignXrefmaxToWindPlantReactiveControlIECEvent.class)
  public void handle(AssignXrefmaxToWindPlantReactiveControlIECEvent event) {
    LOGGER.info("handling AssignXrefmaxToWindPlantReactiveControlIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindPlantReactiveControlIEC entity =
        assignXrefmax(event.getWindPlantReactiveControlIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindPlantReactiveControlIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindPlantReactiveControlIEC(entity);
  }

  /*
   * @param	event UnAssignXrefmaxFromWindPlantReactiveControlIECEvent
   */
  @EventHandler(payloadType = UnAssignXrefmaxFromWindPlantReactiveControlIECEvent.class)
  public void handle(UnAssignXrefmaxFromWindPlantReactiveControlIECEvent event) {
    LOGGER.info("handling UnAssignXrefmaxFromWindPlantReactiveControlIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindPlantReactiveControlIEC entity = unAssignXrefmax(event.getWindPlantReactiveControlIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindPlantReactiveControlIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindPlantReactiveControlIEC(entity);
  }

  /*
   * @param	event AssignXrefminToWindPlantReactiveControlIECEvent
   */
  @EventHandler(payloadType = AssignXrefminToWindPlantReactiveControlIECEvent.class)
  public void handle(AssignXrefminToWindPlantReactiveControlIECEvent event) {
    LOGGER.info("handling AssignXrefminToWindPlantReactiveControlIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindPlantReactiveControlIEC entity =
        assignXrefmin(event.getWindPlantReactiveControlIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindPlantReactiveControlIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindPlantReactiveControlIEC(entity);
  }

  /*
   * @param	event UnAssignXrefminFromWindPlantReactiveControlIECEvent
   */
  @EventHandler(payloadType = UnAssignXrefminFromWindPlantReactiveControlIECEvent.class)
  public void handle(UnAssignXrefminFromWindPlantReactiveControlIECEvent event) {
    LOGGER.info("handling UnAssignXrefminFromWindPlantReactiveControlIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindPlantReactiveControlIEC entity = unAssignXrefmin(event.getWindPlantReactiveControlIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindPlantReactiveControlIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindPlantReactiveControlIEC(entity);
  }

  /**
   * Method to retrieve the WindPlantReactiveControlIEC via an
   * WindPlantReactiveControlIECPrimaryKey.
   *
   * @param id Long
   * @return WindPlantReactiveControlIEC
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public WindPlantReactiveControlIEC handle(FindWindPlantReactiveControlIECQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getWindPlantReactiveControlIECId());
  }

  /**
   * Method to retrieve a collection of all WindPlantReactiveControlIECs
   *
   * @param query FindAllWindPlantReactiveControlIECQuery
   * @return List<WindPlantReactiveControlIEC>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<WindPlantReactiveControlIEC> handle(FindAllWindPlantReactiveControlIECQuery query)
      throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindWindPlantReactiveControlIEC, but only if the id
   * matches
   *
   * @param entity WindPlantReactiveControlIEC
   */
  protected void emitFindWindPlantReactiveControlIEC(WindPlantReactiveControlIEC entity) {
    LOGGER.info("handling emitFindWindPlantReactiveControlIEC");

    queryUpdateEmitter.emit(
        FindWindPlantReactiveControlIECQuery.class,
        query ->
            query
                .getFilter()
                .getWindPlantReactiveControlIECId()
                .equals(entity.getWindPlantReactiveControlIECId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllWindPlantReactiveControlIEC
   *
   * @param entity WindPlantReactiveControlIEC
   */
  protected void emitFindAllWindPlantReactiveControlIEC(WindPlantReactiveControlIEC entity) {
    LOGGER.info("handling emitFindAllWindPlantReactiveControlIEC");

    queryUpdateEmitter.emit(FindAllWindPlantReactiveControlIECQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER =
      Logger.getLogger(WindPlantReactiveControlIECProjector.class.getName());
}
