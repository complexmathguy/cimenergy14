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
package com.occulue.europeanstandards.commongridmodelexchangestandard.statevariablesprofile.statevariables.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.statevariablesprofile.statevariables.validator.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.QueryUpdateEmitter;

/**
 * SvStatus business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of SvStatus related services in the case of a SvStatus business
 *       related service failing.
 *   <li>Exposes a simpler, uniform SvStatus interface to the business tier, making it easy for
 *       clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill SvStatus business related
 *       services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class SvStatusBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public SvStatusBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * SvStatus Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return SvStatusBusinessDelegate
   */
  public static SvStatusBusinessDelegate getSvStatusInstance() {
    return (new SvStatusBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createSvStatus(CreateSvStatusCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getSvStatusId() == null) command.setSvStatusId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      SvStatusValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateSvStatusCommand - by convention the future return value for a create
      // command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateSvStatusCommand of SvStatus is " + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create SvStatus - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateSvStatusCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateSvStatus(UpdateSvStatusCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      SvStatusValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateSvStatusCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save SvStatus - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteSvStatusCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteSvStatusCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SvStatusValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteSvStatusCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to delete SvStatus using Id = " + command.getSvStatusId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the SvStatus via SvStatusFetchOneSummary
   *
   * @param summary SvStatusFetchOneSummary
   * @return SvStatusFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public SvStatus getSvStatus(SvStatusFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("SvStatusFetchOneSummary arg cannot be null");

    SvStatus entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      SvStatusValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a SvStatus
      // --------------------------------------
      CompletableFuture<SvStatus> futureEntity =
          queryGateway.query(
              new FindSvStatusQuery(new LoadSvStatusFilter(summary.getSvStatusId())),
              ResponseTypes.instanceOf(SvStatus.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg = "Unable to locate SvStatus with id " + summary.getSvStatusId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all SvStatuss
   *
   * @return List<SvStatus>
   * @exception ProcessingException Thrown if any problems
   */
  public List<SvStatus> getAllSvStatus() throws ProcessingException {
    List<SvStatus> list = null;

    try {
      CompletableFuture<List<SvStatus>> futureList =
          queryGateway.query(
              new FindAllSvStatusQuery(), ResponseTypes.multipleInstancesOf(SvStatus.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all SvStatus";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign InService on SvStatus
   *
   * @param command AssignInServiceToSvStatusCommand
   * @exception ProcessingException
   */
  public void assignInService(AssignInServiceToSvStatusCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getSvStatusId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .BooleanProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .BooleanProxyBusinessDelegate.getBooleanProxyInstance();
    SvStatusBusinessDelegate parentDelegate = SvStatusBusinessDelegate.getSvStatusInstance();
    UUID childId = command.getAssignment().getBooleanProxyId();
    BooleanProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      SvStatusValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get BooleanProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign InService on SvStatus
   *
   * @param command UnAssignInServiceFromSvStatusCommand
   * @exception ProcessingException
   */
  public void unAssignInService(UnAssignInServiceFromSvStatusCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SvStatusValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign InService on SvStatus";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign SvStatus on SvStatus
   *
   * @param command AssignSvStatusToSvStatusCommand
   * @exception ProcessingException
   */
  public void assignSvStatus(AssignSvStatusToSvStatusCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getSvStatusId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.statevariablesprofile
            .statevariables.delegate.SvStatusBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.statevariablesprofile
                .statevariables.delegate.SvStatusBusinessDelegate.getSvStatusInstance();
    SvStatusBusinessDelegate parentDelegate = SvStatusBusinessDelegate.getSvStatusInstance();
    UUID childId = command.getAssignment().getSvStatusId();
    SvStatus child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      SvStatusValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get SvStatus using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign SvStatus on SvStatus
   *
   * @param command UnAssignSvStatusFromSvStatusCommand
   * @exception ProcessingException
   */
  public void unAssignSvStatus(UnAssignSvStatusFromSvStatusCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SvStatusValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign SvStatus on SvStatus";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return SvStatus
   */
  private SvStatus load(UUID id) throws ProcessingException {
    svStatus =
        SvStatusBusinessDelegate.getSvStatusInstance().getSvStatus(new SvStatusFetchOneSummary(id));
    return svStatus;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private SvStatus svStatus = null;
  private static final Logger LOGGER = Logger.getLogger(SvStatusBusinessDelegate.class.getName());
}
